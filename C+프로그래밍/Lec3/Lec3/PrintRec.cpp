#include <iostream>
using namespace std;

struct SalesRec
{
    char pID[10];
    int dYear, dMonth, dDate;
    char deliverAddr[40];
};

void PrSalesRec(const SalesRec& sRec);

int main()
{
    SalesRec s = { "C25TV001", 2019, 11, 15, "서울시 종로구 대학로86" };
    PrSalesRec(s);    
    return 0;
}

// sRec는 상수 참조 인수
void PrSalesRec(const SalesRec& sRec)
{    
    cout << "품목코드: " << sRec.pID << endl;
    cout << "배달일자: " << sRec.dYear << "년 ";
    cout << sRec.dMonth << "월 ";
    cout << sRec.dDate << "일" << endl;
    cout << "배달주소: " << sRec.deliverAddr << endl;
}