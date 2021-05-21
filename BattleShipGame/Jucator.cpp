#include "Jucator.h"
#include <iostream>
using namespace std;


Jucator::Jucator() :m_puncte(0) {

}

void Jucator::Initializare_Nave() {
	int decizie;
	int frecventa[6] = { 0 };
	cout << "Introduceti numarul de nave:(!!!<=5)";
	cin >> m_nr_nave;
	cout << "\n";
	cout << "\n1.Nava1";
	cout << "\n2.Nava2";
	cout << "\n3.Nava3";
	cout << "\n4.Nava4";
	cout << "\n5.Nava5";
	cout << "\n6.Nava6\n";
	cout << "Introduceti tipul navei:";
	for (int i = 0; i < m_nr_nave; i++) {
		cin >> decizie;
		if (frecventa[decizie] == 0) {
			if (decizie == 1) {
				V[i] = F1.CreateNava1();
				frecventa[decizie]++;
			}
			else if (decizie == 2) {
				V[i] = F1.CreateNava2();
				frecventa[decizie]++;
			}
			else if (decizie == 3) {
				V[i] = F1.CreateNava3();
				frecventa[decizie]++;
			}
			else if (decizie == 4) {
				V[i] = F1.CreateNava4();
				frecventa[decizie]++;
			}
			else if (decizie == 5) {
				V[i] = F1.CreateNava5();
				frecventa[decizie]++;
			}
			else if (decizie == 6) {
				V[i] = F1.CreateNava6();
				frecventa[decizie]++;
			}
		}
		else {
			do {
				cout << "Nava deja introdusa" << endl;
				cout << "Reintroduceti tipul navei" << endl;
				cin >> decizie;
			} while (frecventa[decizie]!=0);
			if (decizie == 1) {
				V[i] = F1.CreateNava1();
				frecventa[decizie]++;
			}
			else if (decizie == 2) {
				V[i] = F1.CreateNava2();
				frecventa[decizie]++;
			}
			else if (decizie == 3) {
				V[i] = F1.CreateNava3();
				frecventa[decizie]++;
			}
			else if (decizie == 4) {
				V[i] = F1.CreateNava4();
				frecventa[decizie]++;
			}
			else if (decizie == 5) {
				V[i] = F1.CreateNava5();
				frecventa[decizie]++;
			}
			else if (decizie == 6) {
				V[i] = F1.CreateNava6();
				frecventa[decizie]++;
			}
		}
	}
}

Jucator::~Jucator() {
	for (int i = 0; i < m_nr_nave; i++) {
		delete V[i];
	}
}

void Jucator::Incrementatre_Puncte() {
	m_puncte += 100;
}

void Jucator::Decrementare_Puncte() {
	m_puncte -= 50;
}

void Jucator::Show_puncte()const {
	cout << m_puncte << endl;
}