#pragma once
#include "CAnimal.h"

class CAnimalCarnivor: public CAnimal
{
public:
	CAnimalCarnivor();
	CAnimalCarnivor(string& nume, int data, int greutate, string& hrana, int cantitate);
	virtual ~CAnimalCarnivor()=0;
};

