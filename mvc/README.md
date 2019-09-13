# Model-View-Controller
The Model-View-Controller (**MVC**) is a design pattern used for designing and implementing user-interface systems. The MVC pattern works by separating three interconnected pieces of an application: 
  
  - **Model:** The Model performs all of the business logic, as well as interfaces with the data store.
  - **View:** The View displays data and accepts user input.
  - **Controller:** The controller handles the user input, and controls the workflow of the software. 

When building large, interconnected software systems, modularity is key. The MVC pattern facilitates understanding and modifying each module, since each module covers a specific domain. Changes can be made to one module without much or any knowledge of the rest of the system.

This modularity allows for the creation of multiple View classes. Different domains of the system can be visualized without the need for multiple controllers or models.

Sources:  
*  https://web.archive.org/web/20100921030808/http://www.itu.dk/courses/VOP/E2005/VOP2005E/8_mvc_krasner_and_pope.pdf 
*  http://wiki.c2.com/?ModelViewControllerHistory
