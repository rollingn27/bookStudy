#include <iostream>
using namespace std;

int main()
{
	const double PI{ 3.14159 };
	// constexpr �����Ͻ� ��, ���� �ӵ��� ��� ��ų �� �ִ�.
	constexpr int a = 10;
	double radius;

	cout << "���� �ݰ��� �Է��Ͻÿ�: ";
	cin >> radius;
	double area = radius * radius * PI;
	cout << "���� ���� = " << area << endl;

	// if��
	int ifA{ 10 };
	int ifB{ 15 };

	if (ifA < ifB)
	{
		int t = ifA;
		ifA = ifB;
		ifB = t;
	}


	// switch��
	int score;
	char grade;

	cin >> score;

	switch (score / 10)
	{
	case 10:
	case 9:
		grade = 'A';
		break;
	case 8:
		grade = 'B';
		break;
	case 7:
		grade = 'C';
		break;
	case 6:
		grade = 'D';
		break;
	default:
		grade = 'F';
	}

	//for��
	int val, total = 0;
	for (int i = 0; i < 5; i++)
	{
		cin >> val;
		total += val;
	}

	// ���� for��
	int arr[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	int sum = 0;
	for (int a : arr)
	{
		sum += a;
	}

	cout << "�հ� = " << sum << endl;

	// ����

	for (int a : arr)
	{
		cout << "������ arr " << a;
	}
	cout << "-----------------------" << endl;		

	for (int &a : arr)
	{
		++a;
	}

	for (int a : arr)
	{
		cout << "������ arr " << a;
	}

	return 0;
}