#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(vector<vector<int>> sizes) {
    int row = sizes[0][0], col = sizes[0][1];
    for(int i=1; i< sizes.size(); i++)
    {
        if( sizes[i][0] > row && sizes[i][1] > col)
        {
            row = sizes[i][0];
            col = sizes[i][1];
        }
        else if ( sizes[i][0] > row )
        {
            if( sizes[i][0]* max(col,sizes[i][1]) < max(col,sizes[i][0]) * max(row, sizes[i][1]) )
            {
                col = max(col, sizes[i][1]);
                row = sizes[i][0];
            }
            else
            {
                col = max( col, sizes[i][0]);
                row = max( row , sizes[i][1]);
            }
        }
        else if ( sizes[i][1] > col )
        {
            if( sizes[i][1]* max(row,sizes[i][0]) < max(row,sizes[i][1]) *  max(col,sizes[i][0]) )
            {
                col = sizes[i][1];
                row = max(row, sizes[i][0]);
            }
            else
            {
                row = max(row,sizes[i][1]);
                col = max(col ,sizes[i][0]);
            }
        }
        cout << row << " " <<col << endl;
    }
    return row * col;
}