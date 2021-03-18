# ProLogger  

---  

Design Document
<br/>
Robert Freid, TJ Harvey, Danielle Maddux
<br/>
## Introduction  

---  

ProLogger allows you to log custom events into a personal log to keep track of activities performed daily, weekly, and monthly.
<br/>
-	Create customized activity logs to keep track of your events such as exercise routine or work tasks.
-	Take photos or attach images or files to a log.
-	Find location of interest in the area such as restaurants, stores, or parks.
-	Get notified of scheduled events or goals in advance using the calendar.
<br/><br/>
## Storyboard  

---  

[Story Board](https://projects.invisionapp.com/prototype/ckasgvpt700kyob01x4gv0q6e/play)

![ProloggerStoryBoard2_6-9-20](https://user-images.githubusercontent.com/63562613/84225944-714b1980-aaae-11ea-948d-c007674acc25.JPG)

## Requirements  

---  

### Requirement 100: Create Log  

---  

#### Scenario  

As a user who is interested in an application to keep a personal log that tracks of various activities performed daily, weekly, monthly, I want to be able to log these activities in a digital journal with the ability to add comments or notes on each log that are time stamped.  

#### Dependencies  

- No dependencies required for this action  

#### Assumptions  

- Standard action icons are used such as a calendar icon, the attachment icon, or camera icon  

#### Example  

1.1 **Given** I am entering new work task
<br/>
**When** I submit the new work task
<br/>
**Then** the task should be displayed on main screen along with other current and past log information
<br/>  

1.2 **Given** I am entering new work task
<br/>
**When** I cancel the new work task
<br/>
**Then** the main screen should display my and current and past log information but should not commit the canceled task
<br/>  

1.3 **Given** I am entering new work task
<br/>
**When** I do not enter data in the required areas such as the name of the task and category
<br/>
**Then** a warning should alert me to correct the action before proceeding
<br/>  

### Requirement 101: take pictures/attach pictures or files in a log  

---  

#### Scenario  

As a user who is interested in an application to keep a personal log that tracks of various activities performed daily, weekly, monthly, I want to be able to take pictures and/or attach pictures or files to a logged event.
  

#### Dependencies  

- The phone has an available camera and the app has permissions to use the camera
- The app has permissions to access files on the phone
  

#### Assumptions  

- Standard action icons are used such as a calendar icon, the attachment icon, or camera icon
- The app has permission to access files and to use the camera on the phone
  

#### Example  

1.1 **Given** I am taking a picture from an opened log
<br/>
**When** I take the picture
<br/>
**Then** the app should ask if I wish to attach the picture, if yes, attach picture to opened log
<br/>  

1.2 **Given** I am taking a picture from an opened log
<br/>
**When** I take the picture
<br/>
**Then** the app should ask if I wish to attach the picture, if no, then return to camera
<br/>  

1.3 **Given** I am attaching a picture/file to a log
<br/>
**When** I click on the attachment paperclip symbol
<br/>
**Then** a browse box should display so I may select the appropriate picture/file to attach
<br/>  

### Requirement 102: determine locations in area using GPS  

---  

#### Scenario  

As a user who is interested in an application to keep a personal log that tracks of various activities performed daily, weekly, monthly, I want to be able to find specific locations of interest nearby such as restaurants, stores, or parks using GPS.
  

#### Dependencies  

- The phone has a map function available
- The app has permissions to use the location function on phone
  

#### Assumptions  

- Standard action icons are used such as a calendar icon, the attachment icon, or camera icon
- The app has permissions to use the location on the phone
- The phone has internet connection
  

#### Example  

1.1 **Given** I search for retail stores in search of a hardware store within the area 
<br/>
**When** I click on map
<br/>
**Then** the app should open the map module within the phone
<br/>  

1.2 **Given** I want to save a hardware store I found in the map search to the specific log
<br/>
**When** I click on map and select hardware store
<br/>
**Then** the app should have an option to save hardware store to log
<br/>  

### Requirement 103: set events or goals in a calendar to push reminder notifications  

---   

#### Scenario  

As a user who is interested in an application to keep a personal log that tracks of various activities performed daily, weekly, monthly, I want to be able to set events or goals in a calendar that will push reminder notifications.
  

#### Dependencies  

- The app has permissions required to be able to push notifications
  

#### Assumptions  

- Standard action icons are used such as a calendar icon, the attachment icon, or camera icon
- The app has permissions required to be able to push notifications
  

#### Example  

1.1 **Given** I want to set an event or goal in the calendar
<br/>
**When** I click on the calendar
<br/>
**Then** the app should open the calendar and allow you to enter a task for that day
<br/>  

1.2 **Given** I want to set an event or goal in the calendar
<br/>
**When** I start a new log
<br/>
**Then** the app will have a date option you can modify to add to the calendar
<br/>  

1.3 **Given** I want to set a reminder that will push a notification
<br/>
**When** I click on the calendar
<br/>
**Then** select the option to set a reminder for the event
<br/>  

1.4 **Given** I want to set a reminder that will push a notification
<br/>
**When** I start a new log
<br/>
**Then** select the option to set a reminder for the event
<br/>  

### Requirement 104: allow tasks to be pushed or reviewed by organization  

---  

#### Scenario  

As a user who is interested in an application to keep a personal log that tracks of various activities performed daily, weekly, monthly, I want to be able to have others to be able to push tasks to me or review my tasks as part of an organization.
  

#### Dependencies  

- The app has permissions required to be able to push notifications
- The phone is able to connect to the internet
- The app is connected to an organization
  

#### Assumptions  

- Standard action icons are used such as a calendar icon, the attachment icon, or camera icon
- The app has permissions required to be able to push notifications
- The phone has internet connection
- The app is connected to an organization
  

#### Example  

1.1 **Given** the app has an option to submit for review to organization
<br/>
**When** I submit a task that needs reviewed
<br/>
**Then** the task will also save the log per usual with an indicator that it was submitted for review
<br/>  

1.2 **Given** I need to have my tasks reviewed or tasks pushed to me
<br/>
**When** a submitted task has been reviewed
<br/>
**Then** the app will notify me of the review results and have the updated task marked with the review notes within the app
<br/>  

1.3 **Given** I need to have my tasks reviewed or tasks pushed to me
<br/>
**When** a task is pushed to me
<br/>
**Then** the app will notify me of the task and will display as a task under the given organization category
<br/>  

1.4 **Given** I need to have my tasks reviewed or tasks pushed to me
<br/>
**When** I complete a task that was pushed to me
<br/>
**Then** the app will send a notification to the organization that pushed the task and the task will update within the app and marked as complete with any notes or comments that were added
<br/>  

## Class Diagram  

---  

![Prologger_UML_Diagram-ForFinalReview](https://user-images.githubusercontent.com/63562613/83973842-0e436200-a8b7-11ea-901c-38bb967423ce.jpg)

### Class Diagram Description  

**MainActivity:**  The first screen the user sees. This will have a list of tasks that were logged or that are to be completed.  

**RetrofitLogInstance:**  Bootstrap class required for Retrofit.   

**ContactsDetailActivity:**  A screen that shows the details of the user contacts.  

**MapDetailActivity:**  A section that handles Map activities.  

**AboutDetailActivity:**  A section that handles About activities.  

**Log:**  Noun class that represents the log.  

**Map:**  Noun class that represents a Map task. 

**Contacts:**  Noun class that represents a contact.  

**AboutDetails:**  Noun class that represents About software and company information.  

**ILogDao:**  Interface for Retrofit to find and parse log data.  

**AppContacts:**  Internal app for Contacts.  

**IMapDAO:**  Internal App for Google Maps.  

## Scrum Roles  

---  

Product Owner: Robert Freid
<br/>
Integration Developer/Scrum Master: TJ Harvey
<br/>
Developer: Danielle Maddux
<br/>

## Weekly Meeting  

---  

Tuesdays at 8:30 PM and Thursdays at 8:00 PM. Use this WebEx:
<br/>
Meeting Information Meeting link:
<br/>
https://ucinnstudents.webex.com/ucinnstudents/j.php?MTID=mf68f3ea9ad99228b4791ba8ca4da6bfd
<br/>
Meeting number: 471 291 373  
<br/>
See recordings at this link:
<br/>
https://ucinnstudents.webex.com/recordingservice/sites/ucinnstudents/recording/play/5bcc4e1c739543b98a6a1af8c140eef9  


