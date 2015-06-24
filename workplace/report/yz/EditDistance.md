#Description
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2 and output the change of word1 in each step. (each operation is counted as 1 step.)


You have the following 3 operations permitted on a word:


a) Insert a character


b) Delete a character


c) Replace a character

Input File

1) Line 1: Number of test cases

2) Line 2 to Line N+1: each line is two words separated by space

Output File

1) Line 1: minimum number of steps for test case#1, N1

2) Line 2 to Line N1: the change of word1 of test case#1 after each step until word1 is converted to word2

3) Line N1 + 1: blanket line

Repeat the lines above for next test case until all test cases are done.

Note: If there's no step, output 0
#Basic idea
This is a typical Dynamic Programming question from leetcode. You can definitely find the best solution from discuss if you pay some attention there. Or, read my words and try to get it by your own. 


There is a follow up in this question to show all the partial steps during the transform, if there isn't a solution, output 2 zeros. IF, if ever you have done this question before, you should definitely understand how hard it is. (*Pain in the ass!*)

First of all, let's think about the first half of the question - try to solve the corresponding leetcode problem (be better with a DP solution).

I was trying to solve this problem with normal comparison between two Strings at first. By picking out the in-order common letters from both Strings, I could easily know how many differences between these two words. 

```
i.e.

abcdef , aecfdehi

common substring : a + c + d + e = acde;

//We don't need to change these letters since they are perfectly matched with each other. 
```

Then I tried to use this substring as a window sliding through each of the word, and find the places need to be changed. (It's pretty hard and unnecessary to describe because you will stuck in a trouble with some corner cases.) I didn't finish this algorithm anyway, *sigh* because I suddenly realized DP would be a better solution. You might ask me how can I realize that, well, I have to say because of experience. This is also the purpose of doing such large sum of practice, that is, learn to be sensitive to each kind of problems. 

Two strings, searching through the entire word, no exceptions, one by one, all these clues are trying to tell you DP is the one you are looking for - *2D dp solution*. By creating a map with word1.length height, and word2.length width, we can easily and directly calculate the difference between every two letters. Well think about the map now, you should have a picture  in your brain how this map looks like. 

If you do have a picture in your mind, good job, keep your brain running fast. Otherwise, this might be your first time dealing with 2D dp problem, don't worry I don't understand this at the first time either. :) Here I will draw a map for you.

```
i.e. : word1 = "abc" word2 = "aef"

  | 0 | a | e | f |
  -----------------
0 |   |   |   |   |
  -----------------
a |   |   |   |   |
  -----------------
b |   |   |   |   |
  -----------------
c |   |   |   |   |
```

For each cell of the map, it stores the number of transforming steps needed from word1[i] to word2[j]. We need to initialize the first line and first column since they are on the edge of the map. First row / line means from word1 = "", to word2 = "" or "a" or "ae" or "aef", how many steps do we need to reach there, or say, how many add operations. Same with the first column, minus operations. 

```
  | 0 | a | e | f |
  -----------------
0 | 0 | 1 | 2 | 3 |
  -----------------
a | 1 |   |   |   |
  -----------------
b | 2 |   |   |   |
  -----------------
c | 3 |   |   |   |
```

Each cell in the middle of the map stands for the minimal steps it needs to transfer from word1.substring(0, i) to word2.substring(0, j). You'd better try to find out the relationships by your own because this is the real core of Dynamic Programming skills. And here I'll show you the result:

```
if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
	map[i][j] = map[i - 1][j - 1];
} else {
	map[i][j] = Math.min(map[i - 1][j - 1], Math.min(map[i][j- 1], map[i - 1][j])) + 1;
}
```

Done. 

So far we've solved the basic requirement from leetcode about this question, but the next thing we are going to work at is a lot harder than this. Let's think about how to show the details during the transform.

We knew how many steps do we need to finish the task, it was done in the previous DP. But:
+ First we need to know which cells have we chosen.
+ Second we need to know how word1 changed in each cell.
+ Third we need to store all these words some place, or, print them out.

Again there are many ways to solve it, what I was thinking is to optimize the algorithm as good as I can. I started thinking out a way to merge step 1 and 2 together in order to save time. I tried to scan the map in-order once and finish both step 1 and 2, but I failed. The reason is I can not accurately find out the correct cell stepping in for each time. You need to try some special cases in order to understand this, it's not easy to prove though. *There are way toooooo many details to talk about here, tell me if you want to know.* 

The failure in the previous try forced me to scan the map twice so as to realize the requirement. First time we scan the map reversely, looking for the cells traveled through. Second time we scan the map in-order, print out the current stage. 

It's not difficult to understand the algorithm, but it does need a lot time to make it real. It's complicated, trust me. 
#Optimization
I am still thinking about optimization to this question. Despite of the operation of Strings, I can't come up with any better idea on the algorithm itself.

Hope you could understand all of my words. And hope you enjoy it. :)