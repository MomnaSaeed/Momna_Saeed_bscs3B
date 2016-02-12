#include<conio.h>
#include<iostream>
using namespace std;
int main()
{
	int a[10][10], b[10][10], c[10][10];
	int x, y, i, j, m, n;

	cout << "\nPlease enter the number of rows and columns for  A matrix\n\n";
	cin >> x >> y;

	
	//x rows
	//y columns
	cout << "\nEnter elements for Matrix A \n\n";
	for (i = 0; i < x; i++)
	{
		for (j = 0; j < y; j++)
		{
			cin >> a[i][j];
		}
		cout << "\n";
	}
	cout << "\n\n Elements of Matrix A are :\n\n";
	for (i = 0; i < x; i++)
	{
		for (j = 0; j < y; j++)
		{
			cout << "\t" << a[i][j];
		}
		cout << "\n\n";
	}
	
	cout << "\nPlease enter the number of rows and columns for  B matrix\n\n";
	cin >> m >> n;
	// m  rows of B
	// n columns of B

	cout << "\n\nEnter elements for Matrix B :::\n\n";
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
		{
			cin >> b[i][j];
		}
		cout << "\n";
	}
	cout << "\n Elements of Matrix B are :\n\n";
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
		{
			cout << "\t" << b[i][j];
		}
		cout << "\n\n";
	}
	if (y == m)
	{
		for (i = 0; i < x; i++)
		{
			for (j = 0; j < n; j++)
			{
				c[i][j] = 0;
				for (int k = 0; k < m; k++)
				{
					c[i][j] = c[i][j] + a[i][k] * b[k][j];
				}
			}
		}
	
		cout << "\n\n Multiplication matrix of Matrix A and Matrix B :\n\n";
		for (i = 0; i < x; i++)
		{
			for (j = 0; j < n; j++)
			{
				cout << "\t" << c[i][j];
			}
			cout << "\n\n";
		}
	}
	else
	{
		cout << "\n\ Error in matrices:Multiplication cannot be done";
	}
	_getch();
	return 0;
}
