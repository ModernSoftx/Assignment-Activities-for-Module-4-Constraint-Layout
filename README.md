# Assignment-Activities-for-Module-4-Constraint-Layout

Lab Capital Quiz
Objectives:

    Familiar with Android Studio
    Explore project structure
    Understand view hierarchy
    Understand activity
    Learn layout management
    Open project and manipulate project
    Define Android Virtual Device (AVD)
    Create a simple app
    Execute an app
    Familiar with the relation between activity and layout
    Utilize Toast

Steps:
Step 1: Create a project and name it as CapitalQuiz by using Empty Activity template
Make sure Java is the language selected.
It might take a while for your IDE to finish creating & loading the template. So be patient.
Step 2: Explore the studio
By default two files, activity_main.xml and MainActivity.java, are open in the editor tool window
See what are in the res/values/strings.xml
Step 2.1 Click the activity_main.xml layout file to see the xml definition file (in the Code mode)
You should see ConstraintLayout and TextView elements
Now let’s follow the steps below to change ConstraintLayout to a vertical LinearLayout and let the LinearLayout contain a TextView with a horizontal layout. And the horizontal layout will contain two buttons later.
Step 2.2 Click the Design tab on the upper right hand side to be back to Design mode
Step 2.3 Take actions in the Component Tree
Step 2.3.1 Select ConstarintLayout in the Component Tree
Step 2.3.2 Right click and select “Convert view…” then select “LinearLayout” and click “Apply” button
Step 2.3.3 select Code button to switch to Code mode to view the xml statements
Step 2.3.3.1 Add two attributes to LinearLayout
android:gravity="center"
android:orientation="vertical"

If you type word by word you will see the editor tries to prompt you with guidance.

         Step 2.3.3.2 Remove “Hello World” TextView element and back to Design mode

Step 2.3.3.3 Add a TextView by clicking Text under Palette and drag TextView into Component Tree  underneath LinearLayout

Now on the right side in the editor you will see Attributes panel
Under Layout category in Attributes you will find layout_width and layout_height fields. Make sure these two fields have the following attributes as follows:

                                         "match_parent" for layout_width
                                         "wrap_content" for layout_height

Under “Common Attributes”  you will find “text” field. Click on “Pick a Resource” ellipse toward the end of that field (i.e., row).
Click the “+” sign on the upper left hand corner and select “String Value”

                    Put “question” (without double quotes) into Resource name
                                         Put “Springfield is the capital of Illinois” (without double quotes) into Resource value
                                         Then click “OK” button to create text through New String Value Resource
                                         Click OK to get out of “Pick a Resource”

                    If you open strings.xml you can find a string with "question" as its name is created. So what does it mean?
                    It means you can achieve the same function through the attributes panel or edit the strings file directly.

                        
                
                    Now back to the Design mode of activity_main.xml. Under “All Attributes” (attributes are listed alphabetically there) in the Attributes panel you will find Padding
                    Drill down Padding group to show “padding” field and set 20dp as its value (remember to click "Enter" button after typing 20dp)
 
                    Step 2.3.3.4 See what have been added into the TextView element in activity_main.xml (in the Code mode)
                  
                   It means that if you know the xml you can change the code directly without using the Attributes panel.
 
                    Step 2.3.3.5 Run the app (Make sure you have created some corresponding AVDs) to see what you have achieved.

Step 2.4 Put the following two elements into strings.xml
<string name="true_button">True</string>
<string name="false_button">False</string>

Step 3: Back to activity_main.xml in Design mode

Step 3.1 Find LinearLayout (horizontal) under “Layouts” in Palette. Drag it into Component Tree beneath textView
Step 3.2 In the Attributes panel change layout_width and layout_height to wrap_content
Step 3.3 Click Code tab to see what new xml statements are created
Step 3.4 Back to Design mode
Step 3.4.1 Drag a Button in the Buttons under palette to be inside (included by) the newly created LinearLayout
Step 3.4.2 In the Attributes panel set the text for the button to be @string/true_buton (Actually as soon as you just type @ in the field, auto complete will be activated and show a list for you to select)
Step 3.4.3 Drag another Button in the Buttons under palette to be located below the newly created button and set text to be @string/false_button
Step 3.3.4 In the Design mode you can switch to different device to preview how the layout will be displayed (You could find “Device for Preview” on the top of Design area
Step 3.4.5 Switch to code mode to verify what you have done
Step 3.4.6 Run the app to verify what you have done
You can change the device to see what will perform on different devices if you have created more than one emulator
If you click the buttons, no action is taken because event handler has not added yet.
Step 3.4.7 Open MainActivity.java and try to understand the code in onCreate()
Step 3.4.8 Can you find R (R in R.layout.activity_main) ? (What does R represent? You can google for the answer)

Step 4:    In this step we will connect widgets with code (i.e., Wire widget to Code). That is, when an event happens, the code will be executed. We are going to do the event handling.

                    Two steps: a. Get references to the object/widget
                                         b. Set listener on the object to respond to the event (i.e., user action. For example, a user clicks a button.)
 
                    Step 4.1 Declare two local buttons in MainActivity java (before onCreate() method)
After you type “private Button” the system will prompt you to include the android.widget library. Just do so by pressing Alt + Enter (for Windows platform). Otherwise, you will miss the library and your code won’t run.

                                         Anyway, finish declaring the two buttons as follows:

private Button trueButton;

private Button falseButton;

                     Step 4.2 Get references to inflated buttons
 
                                         Take a look at the activity_main.xml file to see the ids for the two buttons.
                                         For me they are button and button2. (Why? They are generated by the system.  Yours may be different. So watch out.)
 
                                         In onCreate() put the following code after setContentView(R.layout.activity_main)
 
                    After typing trueButton = findViewById the system may prompt you to select the button. Otherwise just keep typing.
                                        
                                         For me the code is:

trueButton = findViewById(R.id.button);

falseButton = findViewById(R.id.button2);

If the ids in your xml file are different with mine, you have to change the code accordingly. Otherwise, it won't work.

Step 4.3 Implement listener interface for the listener (i.e., buttons) (by using code completion)
Step 4.3.1: After typing trueButton.setOn you can select OnClickListener, IDE will create trueButton.setOnClickListener(). Then type “new” in the parenthesis, among the hints, you select View.OnClickListener, then the IDE will create the onClick method for the event. Now my code looks like:

trueButton.setOnClickListener(new View.OnClickListener() {

         @Override

         public void onClick(View view) {

       

         }

});

Step 4.3.2: Do the similar thing for falseButton. My code looks like:
falseButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {

    }
});

Step 5: Finish event listener
Step 5.1: Generate a pop-up message (i.e., Toast) to reflect user’s choice.
Step 5.1.1: Go to strings.xml put in two elements:
<string name="correct">Correct</string>
<string name="incorrect">Incorrect</string>

Step 5.1.2: Update the listener code for trueButton in MainActivity.java
We will try to do the following steps:
Type Toast to select the right one (android.widget)
Put Toast inside the onClick() in the trueButton and select makeText(Context, int, int).

         Now finish the code by typing character by character inside onClick(View view) in the trueButton to see how to use Auto Completion
 
                  Toast.makeText(getApplicationContext(), R.string.correct, Toast.LENGTH_LONG).show();

Step 5.1.3: Do the same for falseButton. But change it to R.string.incorrect

                  Toast.makeText(getApplicationContext(), R.string.incorrect, Toast.LENGTH_SHORT).show();
 
 
             Notice the difference between Toast.LENGTH_SHORT and Toast.LENGTH_LONG

Step 6: Run the app and click on buttons to see your work

