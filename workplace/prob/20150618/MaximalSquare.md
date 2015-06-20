# Description

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

<b style='color:red'>red words</b>.
```
<b style='color:red'>red words</b>.
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
```

Return 4.
## Input File

1) Line 1: N, i.e. number of test cases

2) Line 2 to Line N+1: each line is an array for which the ith element is the price of a given stock on day i.

## Output File 

1) Line 1: maximum profit for testcase#1  [If it doesn't exist, output 0]

2) Line 2: indices (starting from 0) of the day to buy and sell for testcase#1 [if nothing exiss, output -1]

3) Line 3: prices (starting from 0) of the day to buy and sell for testcase#1 [if nothing exiss, output -1]

4) Line 4: blanket line

.
<br>
.
<br>

4N-3) Line 4N-3: maximum profit for testcase#N [If it doesn't exist, output 0]

4N-2) Line 4N-2: indices (starting from 0) of the day to buy and sell for testcase#N [if nothing exiss, output -1]

4N-1) Line 4N-1: prices (starting from 0) of the day to buy and sell for testcase#N [if nothing exiss, output -1]


## Requirement

You should implement both top-down and bottom-up dp solution. Any non-dp (e.g greedy) methods are welcome!

## Example

### Input
2
<br>
1 3 5 7
<br>
6 4

### Output
6
<br>
0 3
<br>
1 7
<br><br>
0
<br>
-1
<br>
-1



