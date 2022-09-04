#include <iostream>
using namespace std;

int main()
{
	const double PI{ 3.14159 };
	// constexpr 컴파일시 평가, 실행 속도를 향상 시킬 수 있다.
	constexpr int a = 10;
	double radius;

	cout << "원의 반경을 입력하시오: ";
	cin >> radius;
	double area = radius * radius * PI;
	cout << "원의 면적 = " << area << endl;

	// if문
	int ifA{ 10 };
	int ifB{ 15 };

	if (ifA < ifB)
	{
		int t = ifA;
		ifA = ifB;
		ifB = t;
	}


	// switch문
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

	//for문
	int val, total = 0;
	for (int i = 0; i < 5; i++)
	{
		cin >> val;
		total += val;
	}

	// 범위 for문
	int arr[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	int sum = 0;
	for (int a : arr)
	{
		sum += a;
	}

	cout << "합계 = " << sum << endl;

	// 참조

	for (int a : arr)
	{
		cout << "참조전 arr " << a;
	}
	cout << "-----------------------" << endl;		

	for (int &a : arr)
	{
		++a;
	}

	for (int a : arr)
	{
		cout << "참조후 arr " << a;
	}

	return 0;
}