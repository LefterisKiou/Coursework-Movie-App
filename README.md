The aim of application architectures is to divide the responsibilities of visualizing (View), processing (Controller) and data management (Model).

We are going to compare two of the most popular Design Patterns, Model-View-Presenter (MVP) and Model-View-ViewModel MVVM.

Both of these design patterns provide a way to structure the code and aim to separate the components. They are composed of 3 main components. This has several benefits.
 Firstly, it makes the testing process easier. When the core components of an application are disassociated from other pieces, it is much easier to test each isolated component.
 Moreover, the overall project code is more flexible, cleaner and easier to maintain.

**Model** : The Model represents the data layer, where data is stored. This includes Objects, classes or structures that hold information in the application. This component is responsible for communicating with the database and network layers.

**View** : The View represents the UI that the user will see and interact with. It is responsible for the visualization of data, as well as keeping track of the user&#39;s actions.

**Presenter** : The Presenter acts as a middle-component. It fetches data from and updates the Model layer. It is also responsible for managing the state of the View, depending on the user actions fetched from the it. Presenters have a one-to-one relationship with Views. For each View in an app, a Presenter interface should be created for that View. This has the drawback of increased code size for big applications.

MVVM design shares some similarities with MVP. It is also composed of 3 main components, however the Presenter is replaced by the ViewModel.

**Model** : Similarly to MVP, the Model represents the data layer. It works in synergy with the ViewModel to fetch and store data.

**View** : As with the Model, the view also share similarities with the MVP. It is responsible for the visualization of data, while informing the ViewModel about the user&#39;s actions. This layer does not contain any logic for the application.

**ViewModel:** This is where MVP and MVVM differ. Presenters, can not be shared across multiple Views, while ViewModels can. This way, a large application can minimize the lines of code needed.

Choosing between MVP and MVVM, depends on numerous variables. Complexity of the application, team size, testing frequency, and application maintenance should all be taken into account. For my application, I would choose to use the MVP design pattern. Since it is a small scale application, I can earn the benefits of the MVP without having to face the drawbacks. Moreover, this application is a coursework project, which has no potential of scaling or maintaining long-term.
