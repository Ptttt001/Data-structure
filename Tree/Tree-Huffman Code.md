# Huffman Code
## 大意
依照字元出現頻率，將字元編碼成不等長度的二進位字串，使得編碼後的字串長度最短。
## 步驟圖
![alt text](image-20.png)
從頻率最小的節點開始建立樹，每次從頻率最小的兩個節點，做merge，直到所有節點都merge完畢。

![alt text](image-21.png)

先對所有字母做統計，再建立huffman tree，使用Heap方式建立，minium tree 。(參考queue中的priority queue)   
![alt text](image-22.png)

有一個array 實現heap(priority queue)，內容會依照頻率排序
![alt text](image-23.png)

每次取出最小的兩個節點，做merge。
![alt text](image-24.png)

放回Heap中
![alt text](image-25.png)
重複以上步驟
![alt text](image-26.png)
![alt text](image-27.png)
![alt text](image-28.png)
![alt text](image-29.png)
![alt text](image-30.png)

做到heap中只剩下一個節點
![alt text](image-31.png)

完成後編碼
![alt text](image-32.png)
> Q:huffman code是否唯一?
>
> A:不唯一，建Heap時遇到頻率相同的字母排列不一定一樣，編碼就會一樣。
