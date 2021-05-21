#pragma once
#include <iostream>
#include "Vehicle.h"
#include <fstream>
#include <string>
using namespace std;

void moveVehicleUp(int a[100][100],Vehicle&vehicle);

void moveVehicleDown(int a[100][100], Vehicle& vehicle);

void moveVehicleLeft(int a[100][100], Vehicle& vehicle);

void moveVehicleRight(int a[100][100], Vehicle& vehicle);

void jumpVehicleUp(int a[100][100], Vehicle& vehicle);

void jumpVehicleDown(int a[100][100], Vehicle& vehicle);

void jumpVehicleLeft(int a[100][100], Vehicle& vehicle);

void jumpVehicleRight(int a[100][100], Vehicle& vehicle);

bool checkVehicleUp(int a[100][100], int dimension, Vehicle& vehicle);

bool checkVehicleDown(int a[100][100], int dimension, Vehicle& vehicle);

bool checkVehicleLeft(int a[100][100], int dimension, Vehicle& vehicle);

bool checkVehicleRight(int a[100][100], int dimension, Vehicle& vehicle);

bool checkVehicleJumpUp(int a[100][100], int dimension, Vehicle& vehicle);

bool checkVehicleJumpDown(int a[100][100], int dimension, Vehicle& vehicle);

bool checkVehicleJumpLeft(int a[100][100], int dimension, Vehicle& vehicle);

bool checkVehicleJumpRight(int a[100][100], int dimension, Vehicle& vehicle);

int computeDestinationGoalSum(Vehicle v[100], int dimension);

int computeVehicleDestinationGoal(int startLine,int startColumn,int endLine,int endColumn);

int generateBestVehicleOption(int a[100][100], int dimension, Vehicle& vehicle, string& move, int distanceGoal);

void displayParking(int a[100][100],int dimension,ostream&g);

void initializeParking(int a[100][100], int dimension);

void initializeGoal(int a[100][100], int dimension);

void checkVehicleMove(int a[100][100], string nextMove, Vehicle& vehicle);

void initialzeVehicles(Vehicle v[100], int dimension);

bool checkGoal(int a[100][100], int b[100][100],int dimension);

