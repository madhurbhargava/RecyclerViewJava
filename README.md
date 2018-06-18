# RecyclerViewJava
Uses the new Jetpack Paging Library

Creating a Paged List using the new Paging Library:

1. Add a RecyclerView to your Layout
2. Add an Adapter(Adapter should be of type PagedListAdapter) to your recyclerview
3. Create a LiveData Paged List and Start Observing it. Inside the observation block submit the new list to the adapter.
    (a.)Creation of a LiveData Paged List - Created using a LivePagedListBuilder which needs a list configuration and a DataSourceFactory
          (i.)Creating of DataSourceFactory - Uses a mutablelivedata and ItemKeyedDataSource
                (a.)Creation of ItemKeyedDataSource - Override 2 methods - load Initial and loadAfter
                      LoadInitial - loads the list for the first time
                       Load after - loads subsequent data
