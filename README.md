RecommenderSystem
===================================

The Recommender System is about analyzing the reviews of movies. The system initialization running time is significantly improved by this design decision.

Introduction
------------

In this project we attempt to implement a routing protocol based on the Optimized
Link State Routing (OLSR) protocol. Full compliance to the standard is not the goal but
rather basic routing between intermediary nodes. Specifically, we aim to be able to
transmit Transmission Control (TC) messages throughout the network and properly
establish Multipoint Relays (MPRs) for the nodes.


Persistent Storage
------------------

The raw data from archive directory will be migrated to the flat files (.csv) when user
initializes the system. Movies, users, and reviews files will be created respectively in
order to store the data sets from archive. After k-means is run, the advertisement file
will be created to store advertisements. In our case, using flat files is more efficient
than using MongoDB. The system initialization running time is significantly improved
by this design decision.


User Preference Model
---------------------

In our implementation, five user preference variables are added to each user profile.
Those five features are based on movie genres, which are Comedy, Drama, Family,
Horror, and Others. The reviews will be classified into those five categories.
The average rating score of each genre of a user is used to compute the value of
each feature (i.e. Sum of a User’s Rating for the Movies of a Genre / Total Number
of That Kind of Movies the user rated). To improve the categorizing accuracy, we
use several keywords to determine one genre. For instance, the following keywords
is used to determine comedy: laugh, funny, comical, and comedy. If a movie can not
be categorized to the four genres, it will be treated as others.


Communities Determination Algorithm
-----------------------------------

We consider each user profile as a vector that has five dimensions. Each dimension
reflects a users’ preference on a genre. There are several algorithms can be used for
this purpose including Genetic Algorithm and K-Means. In our implementation, we
decided to use k-means algorithm for community classification.


Advertisement Categories
------------------------

Since there are five genres of movies and ten levels of ranking for each genres. The
Advertisement Factory is consisting of the same five genres and the ten relative
levels to the genre. The total number of the Advertisements Factory will be the
number of genres multiply by the number of relative level. For each contents of every
advertisement, we assume it will be particular advertising in real world. In our case,
we are using simply information which is representing the relative level to the genre
of the movie which is belongs to corresponding cluster. Therefore, it will have fifty
advertisements in the Advertisement Factory.


Advertising Mechanism
---------------------

Generally, it depends on the result of the K-Mean Algorithm. The idea is based on
the given user and page. The Advertisement Factory will be generated in the
beginning. We could find the cluster advertisements by cluster which is determined
by the given user. It contains five genres of advertisements corresponding to the
rating of the user cluster. The given page provides the numbers of the reviews which
comes from the users. According to the reviews, we could determine what the genre
of the movie is. Therefore, we could combine the clusters’ advertisement and the
genre of the movie to determine what the final advertisement is.