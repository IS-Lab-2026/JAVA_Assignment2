# Bicycle Rental & Mushroom Classifier (Java Swing)

A desktop Java Swing application combined into a single executable source file (`ByicleRentalApp.java`). The application features a central welcome navigation menu that leads to two functional sub-applications: a **Bicycle Rental Calculator** and a **Mushroom Species Classifier**.

---

##  Application Architecture

The entire project is structured within **`ByicleRentalApp.java`** using static inner `JFrame` classes to manage different UI screens cleanly:

1. **`WelcomeFrame`**: The entry menu window.
2. **`BicycleRentalFrame`**: The rental cost calculator window.
3. **`MushroomFrame`**: The mushroom species identifier window.

---

## 🖥️ Screen Explanations & How They Work

### 1. Welcome Screen (`WelcomeFrame`)

* **Purpose:** Serves as the main launchpad for the application.
* **How It Works:** 
  * Displays the main project title, two primary feature buttons, and author branding.
  * When a user selects a feature, it instantiates the corresponding frame (`BicycleRentalFrame` or `MushroomFrame`), makes it visible, and disposes of (`dispose()`) the `WelcomeFrame` to optimize system memory.

#### 🔘 Button Breakdown
* **`Bicycle Rental` Button:** Opens the Bicycle Rental Calculator window and closes the Welcome menu.
* **`Mushroom` Button:** Opens the Mushroom Classifier window and closes the Welcome menu.

---

### 2. Bicycle Rental Calculator (`BicycleRentalFrame`)

* **Purpose:** Calculates total rental fees for a bicycle based on start and end hours in 24-hour format.
* **How It Works:**
  * Accepts integer inputs for **Start Time** ($0 \le \text{start} \le 23$) and **End Time** ($1 \le \text{end} \le 24$), ensuring $\text{start} < \text{end}$.
  * Validates user inputs against non-numeric entries or invalid ranges, outputting `"Invalid input time."` if validation fails.
  * Iterates hour-by-hour from `start` to `end`, accumulating the total cost in Rwandan Francs (**RWF**) based on three time-of-day pricing tiers:

| Time Slot (24h Format) | Rate per Hour | Description |
| :--- | :--- | :--- |
| `00:00 – 07:00` & `21:00 – 24:00` | **500 RWF** | Night / Early Morning Rate |
| `07:00 – 14:00` & `19:00 – 21:00` | **1,000 RWF** | Standard Daytime / Evening Rate |
| `14:00 – 19:00` | **1,500 RWF** | Peak Afternoon Rate |

#### 🔘 Button Breakdown
* **`CALCULATE` Button:** Reads the `Start Time` and `End Time` fields, runs validation check logic, calculates the total cost across all hours, and displays the total in RWF in the read-only output field.
* **`CLEAR` Button:** Resets the `Start Time`, `End Time`, and `Total` text fields back to empty.
* **`BACK` Button:** Closes the rental calculator frame (`dispose()`) and re-opens the `WelcomeFrame` main menu.

---

### 3. Mushroom Classifier (`MushroomFrame`)

* **Purpose:** Identifies specific mushroom species based on visual and environmental attributes.
* **How It Works:**
  * Displays four physical trait questions with mutually exclusive **Yes/No** radio button options grouped using `ButtonGroup`.
  * Executes a binary decision tree algorithm when evaluated:
    * **Convex Cap = Yes:**
      * **Ring = No:** Classifies as **Pied bleu**.
      * **Ring = Yes:** Checks habitat. **Forest = Yes** $\rightarrow$ **Amanite tue-mouches**; **Forest = No** $\rightarrow$ **Agaric jaunissant**.
    * **Convex Cap = No:**
      * **Ring = Yes:** Classifies as **Coprin chevelu**.
      * **Ring = No:** Checks gills. **Gills = Yes** $\rightarrow$ **Girolle**; **Gills = No** $\rightarrow$ **Cèpe de Bordeaux**.
  * Displays missing-answer prompts if necessary questions in the decision path are left unselected.

#### 🔘 Button Breakdown
* **`CHECK` Button:** Inspects selected radio buttons, checks for required inputs, runs the decision tree classification logic, and outputs the result string to the text box.
* **`CLEAR` Button:** Deselects all radio buttons across all four questions and clears the result field.
* **`BACK` Button:** Closes the mushroom detector frame (`dispose()`) and re-opens the `WelcomeFrame` main menu.

---

## 🛠️ How to Compile & Run

### Command Line (`javac` / `java`)
```bash
# Navigate to your source package directory and compile:
javac com/mycompany/byiclerental/ByicleRentalApp.java

# Execute the application:
java com.mycompany.byiclerental.ByicleRentalApp
```

### Apache NetBeans / IDE
1. Open the project in Apache NetBeans or your preferred Java IDE.
2. Open `ByicleRentalApp.java`.
3. Press **Shift + F6** (or right-click and select **Run File**).

---

## 👤 Author & Design
`@ designed by DAMOUR arts`
