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
	return 0;
}