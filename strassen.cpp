#include<stdio.h>
#include<conio.h>
#include<iostream>
using namespace std;
int main(){
	int a[2][2], b[2][2], c[2][2], i, j;
	int m1, m2, m3, m4, m5, m6, m7;

	cout <<"please enter  the 4 elements of  matrix: ";
	for (i = 0; i<2; i++)
	for (j = 0; j<2; j++)
		//scanf_s("%d", &a[i][j]);
		cin >> a[i][j];

	cout << "please enter the 4 elements of  matrix: ";
	for (i = 0; i<2; i++)
	for (j = 0; j<2; j++)
		cin >> b[i][j];

	cout <<"\nThe first matrix is\n";
	for (i = 0; i<2; i++){
		printf("\n");
		for (j = 0; j<2; j++)
			cin  >> a[i][j];
	}

   cout <<"\nThe second matrix is\n";
	for (i = 0; i<2; i++){
		printf("\n");
		for (j = 0; j<2; j++)
			cin >> b[i][j];
	}

	m1 = (a[0][0] + a[1][1])*(b[0][0] + b[1][1]);
	m2 = (a[1][0] + a[1][1])*b[0][0];
	m3 = a[0][0] * (b[0][1] - b[1][1]);
	m4 = a[1][1] * (b[1][0] - b[0][0]);
	m5 = (a[0][0] + a[0][1])*b[1][1];
	m6 = (a[1][0] - a[0][0])*(b[0][0] + b[0][1]);
	m7 = (a[0][1] - a[1][1])*(b[1][0] + b[1][1]);

	c[0][0] = m1 + m4 - m5 + m7;
	c[0][1] = m3 + m5;
	c[1][0] = m2 + m4;
	c[1][1] = m1 - m2 + m3 + m6;

	cout << "\nMultiplication matrix is \n";
	for (i = 0; i<2; i++){
		printf("\n");
		for (j = 0; j<2; j++)
			cin>> c[i][j];
	}
	_getch();
	return 0;
}
