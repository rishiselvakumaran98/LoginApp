
# Welcome to my First Android APP!

* Created by Rishi Selvakumaran based on Youtube Video: https://www.youtube.com/watch?v=D3x6otiCR3g

# Summary:

The LoginApp is a very simple Android application that was created using Java and Android SDK UI Framework from Android Studio IDE to perform as a login medium for any type of application or service. While the scope of the application is simple in its usage it was used as a mock project to give me exposure to an develop Android application and also test some of the parameters that a User might want from an login application such as "Register User and also avoiding collision between registering same user names/emails". These features helped me understand some of the Standrard user login testing that should be done in a login page for any application for a user to have better convience and access to their profile. 

# How to use the login Page:

- Upon arriving at the application, the user is directed to the login page where they can find two textboxes to fill in their username/email and also their password. 

![alt text](https://github.com/rishiselvakumaran98/LoginApp/blob/main/img/UserPage.png?){ width: 200px; }



- Upon filling in their username and email they could click on the login button to get authenticated into their profile. If the User has not yet registered then they could click on the "Sign up here!" button to register their username and password. Upon registering the users are once again redirected back to the login page to login to their profile. After successful login, the users are rdirected to an empty page saying "Welcome to App".


# Special features:
- The username and password are stored in the local android device (in a .xml file) through a HashMap function from the Java `java.util.HashMap` library.This function was very useful in hashing the value (in this case the passwords) of the user credentials with their given username and storing them in Hash table Data Structure. To resolve possible collisions in different users trying to register using the same username or email address, conditional statements were used in the main RegistrationActivity.java file to access if user has already registered for their account.

# Bug fixes and addtional features to consider implementing in the future version of Project:

- A forgot password feature should be implemented where the user would be able to get a secured link to their email (Similar to my CSInsiders Project) to get access to change their passwords.

- A email regex should be implemented in the textbox for the username registeration to make sure that the user only sets their email address as the defualt username for accessing their account.

- Give a better UI and layout for the login app such that the users enjoy accessing it.

- Instead of storing the usernames and passwords in the offline database of the Android device, the usernames and passwords should be stored on online clud platforms such as Aws, MongoDb or Google firebase. This would be very helpful in making sure that the user could also access their profiles in the application from a website based applicaion or without reliance on their local storage in their devices which would be very convienient.

# Constraints in Project:

- Time was one of the major constraints in the project as I developed this mock application within 3 hours while watching the youtube videos and also trying to understand the process of how to develop a simple android application for beginners. As a web developer, I have previously implemented a full-stack web application (CS_Insiders) and I believe that this application could possibly be implemented more ambitiously as similar to CS_Insiders.

- More Testing should have been done on the login app as developers have to take into consideration the nature of the full-stack app that this android app will be integrated within.

- Some of the common software testing approaches that can be implemented in this application include Unit Tesing, Integrated testing, and upon further feature addon, Regression testing to rigorously test the functionality and side effects of the app before it can be integrated into any type of common use ror client applictations.


# Important Java Packages used for the Application:

- `java.util.HashMap`
- `java.util.Map`
- `android.content.Intent`
- `android.content.SharedPreferences`

# App Inspiration:
* The app was adapted from Youtube Video: 
* Simple Login App Tutorial for Beginners E01 - Login Activity Using Android Studio 3.6.3 (NEW)
* https://www.youtube.com/watch?v=LCrhddpsgKU
