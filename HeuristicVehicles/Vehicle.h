#pragma once

class Vehicle {
public:
	Vehicle();
	~Vehicle();
	int getLinie()const;
	int getColoana()const;
	void setLinie(int lin);
	void setColoana(int col);
	int getDistantaGoal()const;
	void setDistantaGoal(int distanta);
	int getLinieGoal()const;
	void setLinieGoal(int linieG);
	int getColoanaGoal()const;
	void setColoanaGoal(int coloanaG);
private:
	int linie;
	int coloana;
	int distantaGoal;
	int linieGoal;
	int coloanaGoal;
};
