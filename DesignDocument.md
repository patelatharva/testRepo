# Design Document

**Author**: Team95  
**Version**: 1.0.0  

## 1 Design Considerations

We have made some assumptions about the system environment based on the requirements given to us for creating the application and discussions among the team members.

### 1.1 Assumptions

1. The application is going to be used on a smartphone with Android operating system.
2. The application is going to store its data on the device only. There is no data retrieval, backup or synchronization to be performed on remote server.
3. There is no authentication functionality present in the app. The app is assumed to be used without the user performing 'Sign up' or 'Sign in' operations.

### 1.2 Constraints

1. As the application is going to be used on a smartphone, the interactions with the app are going to be driven through touches and gestures of user on the touch screen.
2. The size of the screen is small as compared to desktop applications. Therefore the User Interface has to be designed carefully in format optimized for mobile to enable the user for conveniently using in the app. 

### 1.3 System Environment

1. The application will be run on smartphones and tablets having Android operating system.
2. The minimum Android OS version of the smartphone on which the application can be installed and run is 4.0.3 Ice Cream Sandwich. 

## 2 Architectural Design

In this application, we are following [Model View Presenter](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter "MVP explained on Wikipedia") pattern with [Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html "Original article explaining Clean Architecture") style for design of the system. The MVP pattern is suitable for creating User Interface of application and the Clean Architecture approach emphasizes on separation of concerns between different layers of the application and mandates a direction of dependencies between components from different layers of the system for ease of maintainability and testability of the system. Clean Architecture style led us to add a layer called Domain in middle of two layers namely Data layer and Presentation layer. Domain layer takes care of implementing the use cases served by the application. We have described the architecture thorugh component digaram in following section. 

### 2.1 Component Diagram
![](diagrams/ComponentDiagramForGLM.png)
The components of the system are organized in three logical layers namely: Data layer, Domain layer and Presentation layer. All the methods implementing the database queries will be present in the repository components in Data layer. The logic of the use cases of the application will be implemented by the components included the Domain layer. The Data layer and Domain layer combined can be seen as a _Model_ part of the Model View Presenter pattern. The User Interface of the application will be managed by activity components shown in the Presentation layer. The Presentation layer will contain the _View_ and _Presenter_ parts of the Model View Presenter pattern. The annotated connections between the components show the interfaces provided and required by the corresponding components.

### 2.2 Deployment Diagram

For this application, we are going to deploy all the components of the system on single mobile device like smartphone or tablet. The system doesn't rely on remote server for any of its functionalities. Therefore we have chosen not to create a deployment diagram for this system.

## 3 Low-Level Design

Associations and functionalities of classes present in the Domain layer of the system architecture is shown as class diagram in the following subsection. 

### 3.1 Class Diagram

![](diagrams/design-team.png)
The above class diagram represents the classes present in the Domain layer of the system. Domain layer implements all the use cases of the application. The connections among the classes represent the associations among them based on the requirements of the app.

## 4 User Interface Design
Here are some UI mock-ups that give an idea about how the actual app will look like.  

### View All Grocery Lists
![](UIMocks/1-0_ViewAllGroceryLists.png)

* The user can click on the name of any list to view the items added to that list.  
* Clicking on the round button with plus icon in the bottom right corner will create new list with name "My Grocery list"  
* Clicking on the garbage bin icon will delete the list  

### View and Manage Items in a Grocery List
![](UIMocks/2-0_Viewgrocerylist.png)
* The list of items added to a particular list are shown arranged by the type of the items.   
* The user can click on the checkbox to mark the item as bought and it will cross out the name of item in the list without removing it.  
* Clicking on the quantity of the item will allow to set the quantity.  
* Clicking on garbage bin button will remove the item from the list.  
* Clicking on the rounded button with plus icon in the bottom right corner will launch new screen (activity) for picking an item to be added to this list.    
* Clicking on the checkbox with label "Check-off all items in list" will check-off all the items in the list at once  
* Clicking the pencil icon near the name of the list on the top will allow to change the name of the list  

### Pick an item to be added to grocery list
![](UIMocks/3-0_Pickanitem.png)

* This view shows the hierarchical list of items categorized by their types.  
* Clicking on any of the items shown in the hierarchical list will add that item to the grocery list currently being viewed.  
* Using the search box at the top, user can search for an item by its name.     

### Search for items  
![](UIMocks/4-0_Searchforitems.png)

* The app will show the list of items when adding the name of item in the search box.  
* Clicking on any of the items shown in the search results will add that item to the grocery list currently being viewed.
* If some item desired by user is not present in the search results, the user can add that new item to the database by clicking on '+ Add _item name_ as new item' button. This will launch a new activity screen for adding a new item of specific type.      

### Add a new item of specific type to database
![](UIMocks/5-0_Addnewitem.png)

* The user enters name of new item in the editable text box.  
* The type of the item can be chosen from the drop down list.    
* The unit of quantity can be chosen from the drop down list.  
* Clicking on the add button will add this new item to the app's database. The newly added item will be then visible in the search list and in the hierarchical under type specified while adding that item.  