package com.atulya.basiccompose.models

data class Message(
    val name: String,
    val body: String
)

fun sampleMessages() = listOf<Message>(
    Message("Schopenhauer", "Life swings like a pendulum backward and forward between pain and boredom."),
    Message("Schopenhauer", "A man can be himself only so long as he is alone; and if he does not love solitude, he will not love freedom; for it is only when he is alone that he is really free."),
    Message("Schopenhauer", "Man is never happy, but spends his whole life in striving after something which he thinks will make him so."),
    Message("Schopenhauer", "Religion is the masterpiece of the art of animal training, for it trains people as to how they shall think."),
    Message("Emile M. Cioran", "If each of us were to confess his most secret desire, the one that inspires all his plans, all his actions, he would say: \"I want to be praised.\""),
    Message("Emile M. Cioran", "Only optimists commit suicide, optimists who no longer succeed at being optimists. The others, having no reason to live, why would they have any to die?"),
    Message("Emile M. Cioran", "The more one has suffered, the less one demands. To protest is a sign one has traversed no hell."),
    Message("Emile M. Cioran", "The fact that life has no meaning is a reason to live - moreover, the only one."),
)

