#pragma once

#include "Abstract_Factory.h"
#include "Nava_Tip1.h"
#include "Nava_Tip2.h"
#include "Nava_Tip3.h"
#include "Nava_Tip4.h"
#include "Nava_Tip5.h"
#include "Nava_Tip6.h"

class Factory :public AbstractFactory {
public:
	virtual Nava* CreateNava1() {
		return new Nava_1;
	}
	virtual Nava* CreateNava2() {
		return new Nava_2;
	}
	virtual Nava* CreateNava3() {
		return new Nava_3;
	}
	virtual Nava* CreateNava4() {
		return new Nava_4;
	}
	virtual Nava* CreateNava5() {
		return new Nava_5;
	}
	virtual Nava* CreateNava6() {
		return new Nava_6;
	}
};