This application shows Trending Movies in Android Application developed using 
The Movies Database(TMDB) API and MVVM Architecture in Java. 
The application uses the internet to fetch data from the API 
and displays the data in the form of GridView made using GridLayoutManager in RecyclerView,
where each grid contains a CardView consisting of ImageView of movie poster and textView of movie rating. 
There are two model classes Movie and Result where Result handles the structure of the API’s GET request of 
popular movies and the Movie class deals with the structure of each movie item. The API used is RETROFIT one 
where the particular instance of it operates using an interface to get the movies. The MovieRepository handles 
the initialization of the instance and gets the request while handling it in a MutableLiveData and sends it to
ViewModel on method call. A CustomAdapter is used to layout the views in the RecyclerView and SwipeRefreshLayout is
being used to handle refresh to the data. Each view has onClick functionality where it shows a new activity 
containing the movie poster, title, synopsis, release data and average likes.

<video src="https://github.com/sanjuray/TheMoviesApp/assets/94555333/0f7f3200-7faf-4881-b7d9-274970e8498e" height=550 width=450/>
