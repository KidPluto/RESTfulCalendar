# Requirements

You have been tasked with designing a JaxRS ReSTful API to expose operations for a calendar application. Provide Java interfaces that specify the API, do not implement any business logic.

The entities exposed by this API are (constructors,accessors and mutators excluded for brevity):

````code
@Entity
public class Person {
  @Id
  private int id;
  private String name;
  private String email;
}
````
````code
@Entity
public class Meeting {
  @Id
  private int id;
  private Date start;
  private Date finish;
  private String description;
  @OneToMany
  private Set<Person> attendees;
}
````
````code
@Entity
public class Calendar {
  @Id
  private int id;
  private int month;
  private int year;
  @OneToMany
  private Set<Meeting> meetings;
  @OneToMany
  private Set<Person> sharedWith;
}
````
The backend systems include (do not implement these):
* SchedulerEngine - Creates a list of times when a set of people are free to attend a meeting on a given day.
* CalenderSyncJob - Syncronizes calendar entries with another calendar system. Does not export attendees, only meetings for each calendar month.

The frontend UIs include (do not implement these):
* MonthlyCalendarApp - Shows the user a monthly calendar which shows all meetings for the month. A user can click on a meeting to see the attendees or reschedule.
* SchedularApp - Allows a user to schedule a meeting including selecting attendees for the meeting.

Please create one or more service interfaces providing an API with enough functionality to meet the needs of these systems and UIs. Limit duplication of functionality as much as possible, but consider scalability in doing so.

Describe how your API solves each of the use cases for the backend systems and UIs.

Suggestions of additional functionality are welcome.

# Test cases

* View calendar
  * Shows meetings
* View meeting
  * Shows start and end times
  * Shows attendees
* Schedule a meeting
  * Review times when people are available
  * Select meeting start and end times
  * Select people
  * Create meeting
* Reschedule a meeting
  * Review / update start and end times
  * Review / update attendees
  * Create meeting
  * Delete original meeting
* Sync calendars
  * Export meetings for calendar

# Notes

Calendar represents 
* One month
* One or more meetings
* Shared with one or more people
* The calendar is by group or company, not per person.  

SchedulerEngine – backend system
* Input: 
  * Meeting start and end dates
  * List/set of attendees
* Output: 
  * List of times when set of attendees are available

CalendarSyncJob – backend system
* Input: Month X for Calendar1, Month Y Calendar2
* Output: ?
* Not sure what this does

MonthlyCalendarApp – frontend UI
* Show one month
* Show all meetings for that month
* Select meeting to view attendies
* Select meeting to reschedule meeting – this calls ScheduleApp?
* Assumption: create meeting – this calls SchedulerApp

SchedularApp – frontend UI
* Create meeting
* Select attendees
* Available dates/times shown? - this calls SchedulerEngine?

Assumptions


[https://www.tutorialspoint.com/restful/restful_quick_guide.htm]
See UserService.java, second example


## API

* GET /calendar/{calendar#}
* GET /meeting-detail/{meeting#}
* GET /meeting
* PUT /meeting
* DELETE /meeting/{meeting#}
