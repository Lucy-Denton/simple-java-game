# simple-java-game

One of the coursework projects I submitted during my studies. It showcases my software development ability at the time, which had progressed from complete beginner just a few months prior. Both the project and my ability are still major works in progress!

To initialise the game, run the file SkyWarsGUI.java in the src/cwSkyWars folder. The game rules will be displayed as below.

<img width="440" alt="simple-java-game1" src="https://user-images.githubusercontent.com/74419106/136781642-33d68df5-e472-4812-8ab9-121f52feba27.png">

After starting the game and the Master Ship (MS) has moved, the grid will display the location of the Master Ship as well as the number of Enemy Ships on each square.

<img width="440" alt="simple-java-game3" src="https://user-images.githubusercontent.com/74419106/136769023-5738df62-c05c-4da1-b4a6-64e191965707.png">

<img width="440" alt="simple-java-game4" src="https://user-images.githubusercontent.com/74419106/136769053-28d3222e-2731-4539-88e9-fcced3694a5d.png">

When a new Enemy Ship is created, the user is asked to name it. The user can type in anything here.

<img width="440" alt="simple-java-game2" src="https://user-images.githubusercontent.com/74419106/136769379-27f11556-5455-4c25-be82-f5e53ab178ae.png">

The "Mode" and "Save" buttons are yet to be programmed, and more importantly, the master ship is yet to be able to destroy enemy ships. Nonetheless, the user can continue to move the master ship, watch as it moves closer and further away from enemy ships, until the game eventually ends when the master ship is destroyed by moving on to a square with at least two enemy ships.

The game logic is in the Game.java file and the computations to generate the random movement of all the ships are in the MoveButton.java file.
