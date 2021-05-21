#pragma once
#include "Nava.h"

class AbstractFactory {
public:
	virtual Nava* CreateNava1() = 0;
	virtual Nava* CreateNava2() = 0;
	virtual Nava* CreateNava3() = 0;
	virtual Nava* CreateNava4() = 0;
	virtual Nava* CreateNava5() = 0;
	virtual Nava* CreateNava6() = 0;
};