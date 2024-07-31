# Search Structures
## AVL tree
### Definition
AVL tree 左子樹高度與右子樹高度差不超過1的二元搜尋樹。
BF值=hL-hR，hL為左子樹高度，hR為右子樹高度。
- 每次insert或delete後，都要檢查BF值
- 會有四種情況需要調整
  - LL: 插入節點在左子樹的左子樹
    左邊比較深，把左子樹提升到root，左子樹的右子樹變成新root的右子數的左邊。
    ![alt text](image-2.png)
  - LR: 插入節點在左子樹的右子樹
    把c往上
    ![alt text](image-4.png)
    ![alt text](image-5.png)
  
  - RR: 插入節點在右子樹的右子樹
    右邊深，把右子樹提升到root，舊root右子樹的左子樹變成新root的左子樹的右邊。
    ![alt text](image-3.png)
  - RL: 插入節點在右子樹的左子樹
![alt text](image.png)
![alt text](image-1.png)
### Complexity
![alt text](image-6.png)
- search for kth item : 參考the k th largest element(用一個新欄位紀錄左子樹的大小+1(自己)的大小，和k比較，k小往左走，k大往右走)
> 建立AVL tree的complexity?

### optimal binary search tree
如何確定最佳的binary search tree結構?
透過tree cost計算，最佳的tree，一定cost最小。
- internal path: 從root到每個node的路徑長度總和(總和到leaf會經過幾個node)
- external path: 從root到每個leaf的路徑長度總和(總和到最下面方塊會經過幾個node)
![alt text](image-7.png)
![alt text](image-8.png)
另一種計算方式 考慮每個node的level，level*出現機率
![alt text](image-9.png)
example:(while) 1/7*1 + (if) 1/7*2 + (do) 1/7*3  + (方塊總和)(3+3+2+1)*1/7 =15/7
![alt text](image-10.png)
#### cost 計算公式
![alt text](image-14.png)
#### cost 計算範例

1. 範例1
  ![alt text](image-11.png)
  ![alt text](image-12.png)
2. 範例2(以code角度)
  是一個dynamic programming的問題，從最小的問題開始解，一步一步解決大問題。
  ![alt text](image-13.png)

  ## M-way search tree
  binary search tree 有兩個child，m-way search tree有m個child。
  ### 特點:
  相較於binary search tree，每個node最多兩個child，m-way search tree每個node最多m個child，遇到資料量大時，可以減少tree深度，搜尋較快。
  
  ### m要是多少?
  ### B-tree
  #### Definition
  B-tree是一種m-way search tree，m是一個常數
  - root至少有兩個child
  - 除了root和leaf，每個node至少有m/2個child
  - 若
  ##### 例子
  m=4
  ![alt text](image-15.png)
  ##### search
  ![alt text](image-16.png)

  - 2-3 tree:3 tree範例
  ![alt text](image-19.png)
  ##### insert
  node滿了，需要處理overflow，需要做split
  ![alt text](image-17.png)

  insert 70，可以直接插入
  ![alt text](image-20.png)

  insert 30，node滿了，需要處理overflow，需要做split
  1. insert值與node值比較，找出中間值
  2. 中間值提升為parent
  3. 最大值變成新node
  ![alt text](image-21.png)

  insert 60，node滿了，需要處理overflow，需要做split

  ![alt text](image-22.png)


  ##### delete
  delete後，node太少，不滿足B-tree條件，需要處理merge
  ![alt text](image-18.png)

  delete 70，可以直接刪除
  ![alt text](image-23.png)

  delete 90，可以直接刪除
  ![alt text](image-24.png)

  delete 60，node已空，做rotate
  1. 50往下推
  2. 20往上送
  ![alt text](image-25.png)
  
  combine
  1. 80往下推
  ![alt text](image-26.png)
  ###### rotate
  有足夠的value可以做rotate
  - 找parent補位置，鄰近的node補上parent的位置
  1. 被刪除的p在左邊
   ![alt text](image-29.png)
  2. 被刪除的p在中間
  ![alt text](image-30.png)
  3. 被刪除的p在右邊
  ![alt text](image-28.png)
  ### B+ tree
  用於database等，和B-tree相似，但leave是一個pointer，指向一個List，List裡面存放各種資料。
  在range query時，很有用。
  ![alt text](image-31.png)
  #### definition
  - 定義一個d為 B+ tree的order
  - B+ tree的root 1~2d個child
  - 除了root和leaf，每個node至少有d~2d個child
  #### example
  order=2
  ![alt text](image-32.png)
  #### search
  找大於24，從24與30之間往下後，透過double linked list找到右方siblings。
  ![alt text](image-33.png)

  找5和24之間的值，從5往下後，透過double linked list找到右方siblings，直到24。
  ![alt text](image-34.png)
  



