#include <iostream>
using namespace std;

int main()
{
	const double PI{ 3.14159 };
	constexpr int a = 10;
	double radius;

	cout << "���� �ݰ��� �Է��Ͻÿ�: ";
	cin >> radius;
	double area = radius * radius * PI;
	cout << "���� ���� = " << area << endl;
	return 0;
}