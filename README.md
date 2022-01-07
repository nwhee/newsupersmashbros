# newsupersmashbros

This game is based off of *Super Smash Bros*. It includes two players on a platform who fight against each other using projectile attacks. Each player has 3 stocks and 100 health points for each stock.  

### Code Walkthrough
https://drive.google.com/file/d/1NpXlch0TNNQHqcH43V-z4Iaq_0ayNDl7/view?usp=sharing

### **Background**
A random background is picked each time the game launches. There are three different backgrounds. 
The Background class includes an array of images. 
![image](https://user-images.githubusercontent.com/54755468/148613525-e7bd8a6d-e3ba-47fc-a8b9-bc51162067e4.png)
![image](https://user-images.githubusercontent.com/54755468/148613556-4c737d7c-fe67-476c-9caf-443844c8d1b9.png)
![image](https://user-images.githubusercontent.com/54755468/148613590-0df7ac2b-0f27-48e2-ad72-918596d3e141.png)


##### Background in Frame

- Created an Array and storing the Background Objects
- Math.random is the function that is swapping between the three images
- Painting will actually draw the images 

![image](https://user-images.githubusercontent.com/85975474/148612624-79134b8d-edb0-44ec-bf9a-cec5aac00976.png)

##### Background Class 

- Creates the constructor and sizing for each of the backgrounds
![image](https://user-images.githubusercontent.com/85975474/148612643-81e1418a-7984-4fe4-86ec-a47bcd3c6c60.png)
![image](https://user-images.githubusercontent.com/85975474/148612656-f6b8afd0-b3df-40d0-8022-42cc380bf301.png)


### **Stage**
![image](https://user-images.githubusercontent.com/85975474/148461684-08df4dab-774b-4cc5-8cfa-67ec936d82bd.png)

- Create a hitbox around each player
- Create a hitbox off the stage
- If statement checks if the hitboxes intersected
- If above is true then they lose a life and position is reset

![image](https://user-images.githubusercontent.com/85975474/148617804-d70f5a4b-73f8-4c73-a1c4-1a7d1289bb3b.png)


### **The Players**
The constructor for the players

![image](https://user-images.githubusercontent.com/85975474/148614340-5b9bdbf9-6c2b-445f-9ff3-1df2f6655c1a.png)

The variables that the players use

![image](https://user-images.githubusercontent.com/85975474/148614305-8e5706bd-c7a3-47f4-ba51-70cb69a08ff2.png)

Behaviour Methods of the players

![image](https://user-images.githubusercontent.com/85975474/148614727-94de5124-4db5-4b98-9f27-ee992a0bc4ab.png)

![image](https://user-images.githubusercontent.com/85975474/148614746-fe5c217a-a652-4269-b9b0-59ef1850ffc0.png)


The getters and setters of the players

![image](https://user-images.githubusercontent.com/85975474/148614766-e11c76f6-c402-4a8c-9583-e32724ae6b7e.png)


The creation and painting of both players

![image](https://user-images.githubusercontent.com/85975474/148614220-4f91b03b-6f59-40f2-815b-563cc0f2220b.png)


### **Health and Stocks**

Check the players current health and display it

![image](https://user-images.githubusercontent.com/85975474/148616017-2e264a06-b0fe-40bb-9a7d-81f7a821669a.png)

If a players current health drops below 0 they lose a life and health and position is reset

![image](https://user-images.githubusercontent.com/85975474/148617838-9ef9b54b-3938-4527-88ff-984f940696ca.png)

Player Hitbox that lowers health when hit by projectile

![image](https://user-images.githubusercontent.com/85975474/148617876-fa9d803c-13a0-42a0-90d6-30082c85a075.png)

How the lives images are created

![image](https://user-images.githubusercontent.com/85975474/148618782-980ab31b-3a2d-46d3-8eaa-8eabeeca052c.png)

Method to remove a life

![image](https://user-images.githubusercontent.com/85975474/148618774-5e688b85-7d0c-438b-a0bb-048e0f318f89.png)


### **Projectile**

Creates the constructor for the Projectile 

![image](https://user-images.githubusercontent.com/85975474/148618583-85306b45-9b7f-4566-b202-f5e8124169b8.png)


The behaviour methods of the Projectile

![image](https://user-images.githubusercontent.com/85975474/148618577-e44fdd1d-ca97-4eba-9608-57c582bead0d.png)

Getters and Setters of the Projectile

![image](https://user-images.githubusercontent.com/85975474/148618605-618ef2c0-5a8c-4606-a4bb-2dd7584d5436.png)

Create the Projectile Object

![image](https://user-images.githubusercontent.com/85975474/148618637-29535ad3-bc85-40e0-b08f-bc8678e01d3e.png)


### **Controls**
These portions of code are binding the keys for movement and actions of each player

##### - Player 1 ![image](https://user-images.githubusercontent.com/85975474/148459949-a0063a84-eed5-437b-86e5-0a0a43202115.png)

![image](https://github.com/nwhee/newsupersmashbros/blob/master/assets/Player%201%20Movement%20+%20Actions.PNG?raw=true)
- A: Move Left
- D: Move Right
- W: Jump
- V: Fire Projectile

##### - Player 2 ![image](https://user-images.githubusercontent.com/85975474/148460116-b2883ec6-8fd8-4373-9dfc-7435610775f1.png)

![image](https://user-images.githubusercontent.com/85975474/148611557-01e1a0ad-09fc-4236-9622-cf3ffaf5a2eb.png)
- ← : Move Left
- → : Move Right
- ↑ : Jump
- . : Fire Projectile



### Sprites

![image](https://user-images.githubusercontent.com/85975474/148461032-28b7b3d9-8d61-4f23-b660-5ea8c29606f2.png)

![image](https://user-images.githubusercontent.com/85975474/148461270-f5cb2b5b-9b21-48dd-a2fa-4db5a1f08e3f.png)

![image](https://user-images.githubusercontent.com/85975474/148461396-1e6e29fe-0e39-42a8-994b-c4f1cec50bb1.png)

![image](https://user-images.githubusercontent.com/85975474/148461423-788bf628-dd4e-45e4-9244-4f52b16a80c1.png)

### 


### Contributors
- [Jonathan](https://github.com/nwhee)
- [Rahul](https://github.com/RJ-06)
- [Justin](https://github.com/JustinVFong)
