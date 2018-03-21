# sightly-basics

Please refer to the package org.shreyansh.osgiDemo.htl only for the source codes.

1. Create a component that displays the child pages of the path provided by author .  Note: The child pages list must be fetched by sending a ajax call (Only in disabled mode) to the servlet that takes the path as parameter  

I added a node htl-ajax-node which has the property disabled and child, child specifies the path of the node whose children will be listed. The corresponding script is located in ajax.html which makes the ajax call and lists the children.

2.Create a component that displays the child pages of the path provided by author .  (Create class that extends  WCMUsePojo class)
Note: Use the service for fetching the child pages.

I used /content/form to take the path as input from user and the request is then forwarded to parent.html which calls the method of usepojo class ListChildren which invokes the method of ListChildrenService to return the list of children of the given path.

3.How can we iterate over a map in HTL?

Please refer to /content/map and /apps/map.html. /apps/map.html uses the UseImpl usepojo class to retrieve the map and iterates over it.
