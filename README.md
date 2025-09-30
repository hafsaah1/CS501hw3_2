# CS501 - Homework 3 - Question 2: Box Overlay with Badge

It shows how to use a `Box` layout to place a notification badge on top of a profile picture. It also has a button to show and hide the badge.



## Explanation of the App

This app is built using a few main ideas from the lecture:

* **`Box` for Stacking**: I used a `Box` to stack the badge on top of the profile picture. The lecture on **slide 10** says a `Box` is a "stack layout," and that's exactly what I needed. The profile picture is the first child in the `Box` (so it's on the bottom), and the badge is the second child (so it's on top).

* **`Modifier.align()` for Positioning**: To move the badge to the bottom-right corner, I used `Modifier.align(Alignment.BottomEnd)`. **Slide 11** from the lecture talks about how you can use this to position a specific child inside a `Box`.

* **State for the Toggle**: To make the "Show/Hide" button work, I used `var showBadge by remember { mutableStateOf(true) }`. This is the basic way to handle state in Compose. The badge is wrapped in an `if (showBadge)` block, so it only gets drawn if that variable is `true`.

* **Circular Shapes**: To make the profile picture and the badge circular, I used the `Modifier.clip(CircleShape)`, which was mentioned on **slide 12**.

## How to Use the App

1.  **Run the app**. You'll see a profile picture with a red "!" badge on it.
2.  Click the **"Hide Badge"** button. The badge will disappear.
3.  Click the **"Show Badge"** button. The badge will come back.
