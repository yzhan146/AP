#Description
N heap of stones are placed in a circle around the playground. Stone is to have the order to merge into one pile. Provisions can only choose two adjacent stones piled merged into a new bunch of the new pile of stones. Each time, you merge two adjacent piles of stones, the total number stones in these two piles contributes to your score

Design an algorithm to calculate the n heap the stones merged into a bunch of minimum score and maximum score.
#Basic idea
*Of course the first part of practice should be about Dynamic Programming, but I really can't figure out a DP solution.*

OK, time to talk about the question of stones. This is not a leetcode question which means it's impossible for me to fetch a result from "discuss". *Sigh, a tough time.* Well, when I finally read through the question, I found it was not a hard one. Simple scanning (searching for the biggest adjacent two numbers) and simple adding (adding these two numbers together), then we replace the elements with partial result. Keep looping until there is only one element left. WELL DONE. 

The only challenge we are facing is the "Ring", which means the first and last elements are regarding as "adjacent". There are many ways to solve this problem. Such as add the first element everytime to the last of the sequence and remove it after calculation, or create a circular linked list, or a DP slution that I don't know (shrug). The way I'm using is to create a simple ArrayList to store stone chain, and the reason is quite simple because we can easily insert or delete an element in that (comparing with Array). Next, like I mentioned before, add the first element to the tail when necessary. This is not a good solution anyway, I admitted. If you got an idea about solving this question with DP, pleas teach me. I am eager to know that :(

*Because this is really straight forward, I would like not to paste the code here. Try it if you want to.*
#Optimization
Circular linked list will be a lot easier to operate. But it's still not a DP solution.