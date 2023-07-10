#include <iostream>
using namespace std;

int T, N, M, K, minK, tmp, tmp2, x, y;
int a[100][100];
int main()
{
    // your code here
    freopen("Array/src/TimKiemMaTran/input.txt", "r", stdin);

    cin >> T;
    for (int tc = 1; tc <= T; tc++)
    {
        cin >> N >> M >> K;

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                cin >> a[i][j];
            }
        }

        minK = K;
        for (int i = 0; i <= N - M; i++)
        {
            for (int j = 0; j <= N - M; j++)
            {
                tmp = 0;
                tmp2 = 10000000;
                for (int k = 0; k < M; k++)
                {
                    int dem = 0;
                    while (dem < M)
                    {
                        tmp += a[i + k][j + dem];
                        dem++;
                    }
                }

                int d = tmp - K > 0 ? tmp - K : K - tmp;

                if (d < minK || (d == minK && tmp < tmp2))
                {
                    minK = d;
                    x = i;
                    y = j;
                    tmp2 = tmp;
                }
            }
        }
        cout << "#" << tc << " " << x << " " << y << endl;
    }
    return 0;
}