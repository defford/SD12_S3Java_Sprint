# Medication Tracking System

A Java-based system for managing medications, prescriptions, doctors, and patients.

## Features

- Manage doctors with their specializations and patient lists
- Track patients and their prescribed medications
- Record medications with details like dosage, quantity, and expiry dates
- Handle prescriptions linking doctors, patients, and medications
- Edit details for Doctors, Patients, and Perscriptions

## Project Structure

The system consists of the following main classes:

- `MedicationTrackingSystem`: Core system managing all entities
- `Doctor`: Manages doctor information and their patient list
- `Patient`: Handles patient details and their medications/prescriptions
- `Medication`: Stores medication information
- `Prescription`: Links doctors, patients, and medications

## Class Relationships

- See UML diagram under the docs folder

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Java IDE (Eclipse, IntelliJ IDEA, etc.)

### Installation

1. Clone the repository
- git clone <repository-url>
2. Open the project in your preferred Java IDE
3. Build and run the project

## Usage

The system allows you to:

- Add/remove doctors and their specializations
- Manage patients and their medical records
- Track medications with their details
- Create and manage prescriptions

## How to Use

- Run the Main menu

- Using the main menu Instantiate Doctors, Patients, or Medications by choosing Manage records (1)

- otherwise choose Load Test Data (5) to generate 5 of each

- Choose Manage perscriptions (2) to proccess a new perscription or add a patient to a doctor

- Choose Generate Reports (3) to generate reports for the system summary, expired medication, and Doctors perscriptions

- Choose Inventory Management (4) to restock all medication or specific medication

- Choose Exit(6) to close the program

## License

This project is licensed under the MIT License - see the LICENSE file for details.
