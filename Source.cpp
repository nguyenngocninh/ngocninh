#include <iostream>
using namespace std;

int m, n,X[100];
bool teach[100][100], conflict[100][100];
void solution()
{
	for (int i = 1; i <= n; i++)
	{
		cout << X[i];
	}
	cout << endl;
}
bool check(int v, int k)
{
	if (teach[v][k])
	{
		for (int i = 1; i <= k; i++)
		{
			if ((conflict[i][k])&&(X[i]==v))
			{
				return false;
			}
		}
		return true;
	}
	return false;
}
void Try(int k)
{
	if (k == n)
	{
		solution();
	}
	for (int i = 1; i <= m; i++)
	{
		if (check(i, k))
		{
			X[k] = i;
				
				Try(k + 1);
		}
	}
}

int main()
{
	int k, u, v, h;
	//cout << "nhap so giao vien va so mon hoc ";
	cin >> m >> n;
	while (m--)
	{
		cin >> k;
		while (k--)
		{
			cin >> u;
			teach[m][u] = true;
		}
	}
	//cout << "nhap so luong conflict";
	cin >> h;
	while (h--)
	{
		cin >> u >> v;
		conflict[u][v] = conflict[v][u] = true;
	}
	Try(1);
	system("pause");
	return 0;
}