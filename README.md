# Pick a pup

![Workflow result](https://github.com/odaridavid/pick-a-pup/workflows/Check/badge.svg)

## :scroll: Description

Pick a pup is a very basic jetpack compose app that displays a list of dogs up for adoption and a bit of info about them.


## :bulb: Motivation and Context

My goal was to learn as much as possible about jetpack compose in whatever way possible , so alot of stuff is hardcoded and
a bit of redundancy when creating composables :) ,with that said

Some things that I did get to pick up
- Working with fonts as shown on the header it used a custom font
- Working with images ,in this case making a circular image view was really simple using shapes
- Working with lists and choosing what to show based on the data , no need for the visibility modifiers is totally awesome.
- Navigating to the details screen was pretty straightforward with the nav component
- Aligning elements in the details screen and trying to figure out what was the replacement of frame layout to have the back button overlay the image was an
interesting problem to solve.
- Also how the back button is setup now to be more of a custom composable with icons which change color based on the dark theme configuration change.
- I thought of displaying a snackbar when the adopt button is clicked but making a snackbar isn't as straightforward yet :(

## :camera_flash: Screenshots
<img src="/results/shot_list_dark.png" width="260">&emsp;<img src="/results/shot_details_dark.png" width="260">&emsp;
<img src="/results/shot_list_light.png" width="260">&emsp;<img src="/results/shot_details_light.png" width="260">&emsp;
<img src="/results/pick_a_pup.gif" width="260">

## Attributions

Image by <a href="https://pixabay.com/photos/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=1082141">Free-Photos</a> from <a href="https://pixabay.com/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=1082141">Pixabay</a>

Image by <a href="https://pixabay.com/users/stocksnap-894430/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=2561134">StockSnap</a> from <a href="https://pixabay.com/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=2561134">Pixabay</a>

## License
```
Copyright 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```