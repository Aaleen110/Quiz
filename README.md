# Anti Phishing Quiz Application

The idea of the app is to create awareness amongst people regarding Fake Urls, Phishing, Fake ads, Popups, Rogueware, Ransomware and Scarewares.


| Splash      | Stage      | Settings      | Main      |  
|------------|-------------|------------|-------------|
| <img src="/../master/splash.jpg" width="200">  | <img src="/../master/stage.jpg" width="200"> | <img src="/../master/settings.jpg" width="200"> | <img src="/../master/main.jpg" width="200"> |


## Overview

The app is divided into three main stages.  In the start only stage 1 is unlocked while Stage 2 and Stage 3 are locked. In order to unlock Stage 2 one has to successfully complete Stage 2. Similarly in order to unlock stage 2 the user has to complete Stage 3.

Every Stage has 8 set of questions,  out of which 5 questions are fake while 3 are legitimate. The player has 3 lives in every stage, If a wrong answer is selected, the player will loose a life, and if he looses 3 lives then the player get a Out of Lives message and is directed to Stage select screen. Each round has 2 min time for each round for Medium difficulty, For Hard the time limit is 60 seconds. If time gets up, then the player get a Time Up message and is directed to Stage select screen. We have used CountDownTimer class to manage time.
In every stage the player has two options to select from, One will be correct and other will be wrong. On selection of right answer the button gets coloured respectively. For every correct answer selection, the colour turns green and for every wrong answer selection the colour turns red. A sound effect has also been added on selection of correct and incorrect choices.  On completion of every stage, the congratulations message pops up and unlocks the next stage respectively.  The player can also opt for hint if he wants by pressing the bulb icon on the top right corner of the application.

## Settings
There are 3 settings available in app, which can be accessed by pressing the Settings icon on the Stage Select screen. The settings are stored in SharedPreferences so that user choice is maintained every time the app is opened.
1. MUSIC

Setting this ‘On’ will run a background music in the app and similarly  turning the switch off will stop the background music from being played.

2. SOUND

Setting sound ‘On' will enable button press sound, and action music like Out of lives, Time up and Congratulations sounds, and similarly  turning the switch off will stop all the sounds in the app.

3. DIFFICULTY

Choosing Medium difficulty will give the player 2 minutes time to solve a stage, while in hard difficulty, the time is limited to 60 seconds. The default difficulty set to Medium.

## Stage 1
Scammers will sometimes use fake versions of real businesses' Web addresses or URLS to trick you into revealing your personal information.
Stage 1 contains questions where the player needs to identify whether the URL is Real or Fake, I.e. the player must identify the Legitimate and Fake Url. Player has two options, REAL and FAKE. Different Urls are given in the question box, the player must identify fake and real url 

## Stage 2
Phishing is the fraudulent attempt to obtain sensitive information such as usernames, password and credit card details (and money), often for malicious reasons, by disguising as a trustworthy entity in an electronic communication. It is usually carried by email spooling. Stage 2 contains question related to Phishing. The user needs to identify many situations and take actions with respect to the situation. Whether the situation Legitimate or Phishing. Stage 2 also contains images of some phishing and real emails and player is asked to take corrective action.

## Stage 3
Stage 3 covers fake popup, fake ads, rogueware, ransomware and scareware. The player is given some scenario and is asked whether he shall comply or not in such scenario. Also Rogueware and ransomware attempts are shown as a popup where the user is asked to make a call in order to remove virus from his PC or some other, here the user is asked whether he should or should not make a call to the number provided in the popup.

## Design
App design has been made keeping in mind google material design. Google material card has been used widely in the app. The design of the app is inspired from “https://dribbble.com/" and “https://www.uplabs.com/android"

## Service
A service is run in the background namely MusicService. It is  responsible for playing the background music within the app. MediaPlayer class is used to play the music file in background as a loop. It should be made sure that the service has been stopped via intent when the app is destroyed. The service can be toggled on and off from Settings.

## Dialogs
Dialogs has been used with respective sound effects in the app at places like, 
- When players life reaches 0
- Time gets up
- Stage gets completed

| Congratulations      | Out of life      | Times up      |
|------------|-------------|------------|
| <img src="/../master/congratulations.jpg" width="200">  | <img src="/../master/out_of_lives.jpg" width="200"> | <img src="/../master/timesup.jpg" width="200"> |

This project is made for fun, please star this project if you like it, or you can also send your valuable feedbacks on my email aaleenmirza110@gmail.com
