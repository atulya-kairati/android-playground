From [Navigation in Compose Code lab](https://developer.android.com/codelabs/jetpack-compose-navigation#0).

The 3 main parts of Navigation are the `NavController`, `NavGraph`, and `NavHost`. The `NavController` is always associated with a single `NavHost` composable. The `NavHost` acts as a container and is responsible for displaying the current destination of the graph. As you navigate between composables, the content of the `NavHost` is automatically recomposed. It also links the `NavController` with a navigation graph (`NavGraph`) that maps out the composable destinations to navigate between. It is essentially a collection of fetchable destinations.

- Add latest compose navigation dependency in `build.gradle` (module):
```groovy
implementation "androidx.navigation:navigation-compose:2.6.0"
```


## Setting up `NavHosController`
- The [NavController](https://developer.android.com/jetpack/compose/navigation#getting-started) is the central component when using Navigation in Compose.
- It keeps track of back stack composable entries, moves the stack forward, enables back stack manipulation, and navigates between destination states.

- **Note**: Always create the `NavController` in the topmost level of the compose hierarchy. And pass down its reference to the components that need it. This will ensure that there is only one source of truth and *state hoisting* is applied.

- Get a `NavController` using `rememberNavController` which uses `rememberSavable` internally to provide and preserve `NavController` across recompositions.
```kotlin
val navController = rememberNavController()
```

## Adding a `NavHost`

- `NavHost` is a container which contains composable that are to be navigated.
- In Compose navigation, each destination composable is associated with a **route**, which is a string. Think of it as a webpage route. 
- All destination must have a unique route.
```kotlin
@Composable  
fun RallyApp() {  
    RallyTheme {  

        val navController = rememberNavController()  
  
        Scaffold(  
            topBar = {...}  
        ) { innerPadding ->  

			%% Here%%
            NavHost(
                navController = navController,  
                startDestination = Overview.route, %% <- Route %% 
                modifier = Modifier.padding(innerPadding)  
            ) { // this: NavGraphBuilder
             
		        // builder
				// add destinations here
            }  
        }    
    }
}
```

- `Navhost` takes a builder lambda, here we add our destination using `NavGraphBuilder.composable` extension.


## Adding destination to `NavGraph`

- We add destination to the `NavGraph` in the builder lambda of `NavHost`.
- We do it using `compsable` function. Which is an extension to `NavGraphBuilder.composable`.
```kotlin
NavHost(  
    navController = navController,  
    startDestination = ScreenOne.route,  
    modifier = Modifier.padding(innerPadding)  
) {  
    // builder  
    // destinations go here  
  
    composable(route = Overview.route) {  
        ScreenOne()  
    }  
  
    composable(route = Accounts.route) {  
        ScreenTwo()  
    }  
  
    // ... 
}
```


## Navigating

- Use this to navigate between destinations.
```kotlin
navController.navigate(routeName)
```

- Use this in a callback and don't pass around as an argument.

- **Note:** Calling navigate multiple times with the same route will create multiple copies of that route on the top of the `navStack`.
- To avoid this duplication, we can use `launchSingleTop` flag.
```kotlin
navController.navigate(routeName) { launchSingleTop = true }
```

**Some other useful flags that can be used with `NavController.navigate` are:**
- `launchSingleTop = true` - as mentioned, this makes sure there will be at most one copy of a given destination on the top of the back stack.
- `popUpTo(startDestination) { saveState = true }` - pop up to the start destination of the graph to avoid building up a large stack of destinations on the back stack as you select tabs.
- `restoreState = true` - determines whether this navigation action should restore any state previously saved by `PopUpToBuilder.saveState` or the `popUpToSaveState` attribute.

```kotlin
navigate(routeName) {  
    launchSingleTop = true // will prevent consecutive duplication  
  
    popUpTo( // will go to start destination when back is pressed 
	     controller.graph.findStartDestination().id
        // OR // route = controller.graph.findStartDestination().route !!  
        // [controller] is NavController: NavHostController
    ) {  
        saveState = true  
    }  
  
    // restore state of the composable when navigating to it  
    restoreState = true  
}
```

- To get the current displayed destination, use something like:
```kotlin
val navController = rememberNavController()  
  
// getting current displayed screen  
val currentBackStack by navController.currentBackStackEntryAsState()  
  
val currentDestination = currentBackStack?.destination
```

## Passing arguments 

- To pass the argument alongside your route when navigating, we need to append them together, following a pattern: `"route/{argument}"`.
- Set up a destination which takes an argument in `NavHost`:
```kotlin
composable(route = "baseRoute/{argumentOneArg}") {
	NewScreen(...) // have to pass argumentOne here
}
```

- We can also make the `composable` aware that it should accept arguments by "`arguments`" argument:
```kotlin
composable(  
    route = "baseRoute/{argumentOneArg}",  
    arguments = listOf(  
        navArgument("argumentOneArg") { type = NavType.StringType }  
    )  
) {  navBackStackEntry ->
    ...  
}
``` 

- Get the passed argument when navigating using `NavBackStackEntry` which is passed in `content` lambda of `composable`.
```kotlin
composable(  
    route = "baseRoute/{argumentOneArg}",  
    arguments = listOf(  
        navArgument("argumentOneArg") { type = NavType.StringType }  
    )  
) {  navBackStackEntry ->
    
    val argumentOne = navBackStackEntry.arguments?.getString(argumentOneArg)
	
	NewScreen(argumentOne)
}
```

- To navigate:
```kotlin
val argumentOne = "Hehehehe"

navController.navigate(
	"baseRoute/$argumentOne"
) { 
	...
	... 
}
```
- **Note:** We don't need `{}` surrounding the argument in the route. It's only needed when we are catching it in the destination composable.

## Deep Links

- In Android, a deep link is a link that takes you directly to a specific destination within an app. Navigation Compose supports [implicit deep links](https://developer.android.com/guide/navigation/navigation-deep-link#implicit).
- When an implicit deep link is invoked, for example, when a user clicks a link—Android can then open your app to the corresponding destination.
- Since exposing deep links to external apps isn't enabled by default, you must also add `<intent-filter>` elements to your app's `manifest.xml` file.
- Start by adding the deep link to the app's `AndroidManifest.xml`. You need to create a new intent filter via `<intent-filter>` inside the `<activity>`, with the action `VIEW` and categories `BROWSABLE` and `DEFAULT`.
- Then inside the filter, you need the `data` tag to add a **`scheme`** (`rally` - name of your app) and **`host`** (`single_account` - route to your composable) to define your precise deep link. This will give you `rally://single_account` as the deep link URL.

```xml
<application  
    android:allowBackup="true"  
    android:icon="@mipmap/ic_launcher"  
    android:label="@string/app_name"  
    android:supportsRtl="true"  
    android:theme="@style/Theme.Rally">  
    <activity        
	    android:name=".RallyActivity"  
        android:windowSoftInputMode="adjustResize"  
        android:label="@string/app_name"  
        android:exported="true">  
        <intent-filter>            
	        <action android:name="android.intent.action.MAIN" />  
  
            <category android:name="android.intent.category.LAUNCHER" />  
        </intent-filter>  
        <intent-filter>            
	        <action android:name="android.intent.action.VIEW"/>  
            <category android:name="android.intent.category.DEFAULT"/>  
            <category android:name="android.intent.category.BROWSABLE"/>  
            <data android:scheme="rally" android:host="argumentOneValue"/>  
            <!-- android:host="argumentOneValue" // should be the same route used in the app -->  
        </intent-filter>  
  
    </activity></application>
```

- Now enable deep link trigger in the composable destination.
```kotlin
composable(  
    route = SingleAccount.routeWithArgs,  
    arguments = SingleAccount.arguments,  
    deepLinks = listOf(navDeepLink {  
        uriPattern = "rally://baseRoute/{$argumentOneArg}"  
    })  
) { navBackStackEntry ->  
  
    ...
}
```

- Can test with adb:
```sh
adb shell am start -d "rally://single_account/Checking" -a android.intent.action.VIEW
```

[Check code on Github](https://github.com/atulya-kairati/android-playground/tree/main/NavigationCodelab).