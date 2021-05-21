#pragma once

#include "Nava.h"
#include "Nava_Tip1.h"
#include "Nava_Tip2.h"
#include "Nava_Tip3.h"
#include "Nava_Tip4.h"
#include "Nava_Tip5.h"
#include "Nava_Tip6.h"
#include "Factory.h"


class Jucator {
public:
	Jucator();
	~Jucator();
	void Initializare_Nave();
	void Incrementatre_Puncte();
	void Decrementare_Puncte();
	void Show_puncte()const;
	int GetNrNave()const {
		return m_nr_nave;
	}
	Nava* GetNava(int pozitie)const {
		return V[pozitie];
	}
private:
	int m_puncte;
	int m_nr_nave;
	Factory F1;
	Nava* V[6];
};