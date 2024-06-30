# Tree

## DEFINITION
a collection of nodes

depth:深度

height:高度

degree:pointer個數(point out)

tree也是一種graph

parient:父節點

siblings:同一層的節點

## representation of tree

### list
![alt text](image.png)

### k-ary tree
![alt text](image-3.png)
缺點:空間使用過多

### left child-right sibling
![alt text](image-1.png)
![alt text](image-2.png)
紀錄左子節點和右兄弟節點，簡化空間使用

## binary tree
> binary tree 和 binary search tree 差別?
### binary tree特性:
1. 第i level的node數量為2^(i-1)

2. 最大node總數為(2^k)- 1

### binary tree 節點與邊數關係計算

1. n0 = n2 + 1，n0為degree=0的node數量，n2為degree=2的node數量
2. 總節點數 n=n0+n1+n2
3. 總branch數 B+1=n
4. B=n1+2n2
5. 總節點數 = n1+2n2+1
6. n0=n2+1
>n=n0+n1+n2，B+1=n，B=n1+2n2=>n1+2n2+1=n
>n1+2n2+1=n0+n1+n2=>n0=n2+1

### comparison of binary tree and tree
![alt text](image-4.png)

### full binary tree
每個node都有2個children，除了leaf node，擁有最大量的node，塞滿的意思
![alt text](image-5.png)

### complete binary tree
沒有全滿，但是從左到右塞滿
## 程式實作binary tree
### array
![alt text](image-6.png)

i為該node在array中的index

左子節點:2i

右子節點:2i+1

parent:i/2

優點:快速找到parent和child

缺點:空間使用過多

### linked
![alt text](image-7.png)

優點:節省空間

缺點:找parent較慢

### compare array and linked
![alt text](image-8.png)

## binary tree traversal
1. LVR:inorder
2. VLR:preorder
3. LRV:postorder
4. level order
![alt text](image-9.png)

### 實作方式:
1. recursive
2. inorder,preorder,postorder:stack
3. level order:queue

## 應用
### 計算多項式

### copy tree
用**preorder traversal**，先建立新的節點，再往下找
![alt text](image-10.png)

### tree comparison
![alt text](image-11.png)

> Q : 可否使用inorder ,postorder 做tree copy?
> 
> A : 不行，因為inorder和postorder在copy之前會先往下找，沒有先建立新的節點，這樣樹建不起來。

> 給一個inorder string ，是否可以建立唯一的binary tree?
> 不能

### boolean expression

如何讓電腦可以判斷boolean expression?
1. 使用stack，將運算子放入stack，遇到運算元就pop出來
2. 使用tree，將tree轉換成postorder
![alt text](image-12.png)

tree中必須包含，left child , right child , value , data 
![alt text](image-13.png)
方式:

有n個變數，2^n種可能，將2^n種組合放入tree中嘗試，
![alt text](image-14.png)

![alt text](image-15.png)
postorder步驟:
1. 左子樹
2. 右子樹
3. 以下幾種情況:
   1. 遇到not
        > 將右子樹做not，結果丟到value。
   2. 遇到and
        > 將左子樹和右子樹做and，結果丟到value。
   3. 遇到or
        > 將左子樹和右子樹做or，結果丟到value。
   4. 遇到true
   5. 遇到false









