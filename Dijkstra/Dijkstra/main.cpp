#include <fstream>
#include <vector>
#include <set>
#include <iostream>

#define DIM 50010
#define INF DIM*1000

using namespace std;

vector<pair<int, int>> adjacency_list[DIM]; 
                                           
set<pair<int, int>> tail; 
            

int distances[DIM], x, y, c, no_vertices, no_edges, k;

ifstream fin("dijkstra.in");

int main()
{
    fin >> no_vertices >> no_edges;
    for (int i = 1; i <= no_edges; i++)
    {
        fin >> x >> y >> c; 

        adjacency_list[x].push_back(make_pair(y, c));
        //adjacency_list[y].push_back(make_pair(x, c) );
    }

    for (int i = 1; i <= no_vertices; i++)
    {
        distances[i] = INF; 
    }
    distances[1] = 0; 

    tail.insert(make_pair(0, 1));
    while (!tail.empty())
    {
        int vertex = tail.begin()->second;
        tail.erase(tail.begin());

        for (int i = 0; i < adjacency_list[vertex].size(); i++)
        {
            int neighbour = adjacency_list[vertex][i].first;
            int cost = adjacency_list[vertex][i].second;

            if (distances[neighbour] > distances[vertex] + cost)
            {
                tail.erase(make_pair(distances[neighbour], neighbour));
                distances[neighbour] = distances[vertex] + cost;
                tail.insert(make_pair(distances[neighbour], neighbour));
                cout << tail.begin()->second << " ";
            }
        }
    }
    if (distances[no_vertices] == INF)
    {
        cout << "-1 ";
        return 0;
    }
    
    return 0;
}