#include <iostream>
using namespace std;
void SwapValues(int& x, int& y); // ����

int main()
{
    int a, b;
    cout << "�� ���� �Է��Ͻÿ�: ";
    cin >> a >> b;
    if (a < b) SwapValues(a, b);
    cout << "ū �� = " << a << " ���� �� = " << b << endl;
    return 0;
}

// �� ������ ���� �ٲٴ� �Լ�
// �μ� int &x, int &y: ���� �ٲ� ����
// ��ȯ: ����
void SwapValues(int& x, int& y)
{
    int temp = x;
    x = y;
    y = temp;
}