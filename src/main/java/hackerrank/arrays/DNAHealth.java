package hackerrank.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class TrieNode
{
    public TrieNode[] children = new TrieNode[26];
    public List<Integer> genWeighIndex = new ArrayList<>();

    public boolean isGen = false;
    public int genWeighIndexMin=-1;
    public int genWeighIndexMax=-1;
    public long sumWeight=0;
    public boolean weightSorted = false;

    public TrieNode(){};
    public TrieNode[] getChildren()
    {
        return children;
    }
    public void setIsGen()
    {
        this.isGen = true;
    }

    public  void setGenWeighIndex(int index)
    {
        genWeighIndex.add(index);
        if(genWeighIndexMax == -1 || genWeighIndexMax<index)
            genWeighIndexMax = index;
        if(genWeighIndexMin == -1 || genWeighIndexMin>index)
            genWeighIndexMin = index;
    }
}

class Trie
{
    private TrieNode root;
    public int[][] weights;//[node index][index of weight]

    public Trie()
    {
        this.root = new TrieNode();
    }
    public  void insert(StringBuilder word, int[] healthItems)
    {
        TrieNode current = this.root;
        int count =0;
        int last=0;
        for(int i=0; i<word.length(); i++)
        {
            char tmp = word.charAt(i);
            if(tmp != ' ')
            {
                int indexNode = tmp-'a';
                if(current.children[indexNode] == null)
                {
                    current.children[indexNode] = new TrieNode();
                }
                current = current.children[indexNode];
            }
            else
            {
                current.setGenWeighIndex(count);
                current.sumWeight+=healthItems[count];
                current.setIsGen();
                count++;
                current = this.root;
            }
        }
        current.sumWeight+=healthItems[count];
        current.setGenWeighIndex(count);
        current.setIsGen();
    }



    public long countWeight(String word, int start, int end, int[] weights)
    {
        TrieNode current = this.root;
        long count =0;
        int deep = 0;
        int last =0;
        for(int i=0; i<word.length(); i++)
        {
            current = this.root;
            for(int j=i; j< word.length(); j++)
            {
                int tmp = word.charAt(j)-'a';
                current = current.children[tmp];
                if(current != null && current.isGen)
                {
                    if(!current.weightSorted)
                    {
                        current.genWeighIndex = current.genWeighIndex.stream().sorted().collect(Collectors.toList());
                        current.weightSorted = true;
                    }
                    long tmpCount = current.sumWeight;
                    //System.out.println(current.sumWeight);
                    //System.out.println(start + " " + end  + " "+ current.genWeighIndexMin + " "+current.genWeighIndexMax);
                    /*for(int k= 0; k<current.genWeighIndex.size(); k++)
                    {
                        int tmpIndex = current.genWeighIndex.get(k);
                        if(tmpIndex <= end && tmpIndex >=start) {
                            count += weights[tmpIndex];
                        }
                    }*/
                    for(int k=current.genWeighIndex.size()-1; k>=0; k--)
                    {
                        int tmpIndex = current.genWeighIndex.get(k);
                        if(tmpIndex >end) {
                            tmpCount -= weights[tmpIndex];
                        }
                        else
                            break;
                    }

                    for(int k=0; k<current.genWeighIndex.size(); k++)
                    {
                        int tmpIndex = current.genWeighIndex.get(k);
                        if(tmpIndex <start) {
                            tmpCount -= weights[tmpIndex];
                        }
                        else
                            break;
                    }

                    count+=tmpCount;
                }
                else if(current == null)
                    break;
            }
        }
        return count;
        //
    }
}

public class DNAHealth {




    private static final Scanner scanner = new Scanner(System.in);
    private static final InputStreamReader isr=new InputStreamReader(System.in);


    public static void main(String[] args) {
        try{
            BufferedReader br= new BufferedReader(isr);
            int n = Integer.valueOf(br.readLine());
            StringBuilder st= new StringBuilder(br.readLine());



            StringBuilder tmpHealthItems = new StringBuilder(br.readLine());
            int[] healthItems = new int[n];
            int count =0;
            int last =0;
            for(int i =0; i< tmpHealthItems.length(); i++)
            {
                if(tmpHealthItems.charAt(i)==' ')
                {
                    healthItems[count]= Integer.valueOf(tmpHealthItems.substring(last, i));
                    count++;
                    last = i+1;
                }
            }
            healthItems[count]= Integer.valueOf(tmpHealthItems.substring(last));
            Trie trie = new Trie();
            trie.insert(st, healthItems);

            int s = Integer.valueOf(br.readLine());

            long max =-1;
            long min =-1;
            for(int j=0; j<s; j++)
            {
                String[] inputSequens = br.readLine().split(" ");
                long current = 0;

                int node = 0;
                String string = inputSequens[2];
                current = trie.countWeight(string, Integer.valueOf(inputSequens[0]), Integer.valueOf(inputSequens[1]), healthItems);
                if(min ==-1 || min>current)
                    min = current;
                if(max ==-1 || max< current) {
                    max = current;
                }

            }

            System.out.println(min+" "+max);
        }
        catch(IOException ex)
        {}
    }
}    /*
     
     
        long[] healthScore= new long [s];

        long min = -1;
        long max = -1;
        
        for (int sItr = 0; sItr < s; sItr++) {
            String[] firstLastd = scanner.nextLine().split(" ");

            int first = Integer.parseInt(firstLastd[0]);

            int last = Integer.parseInt(firstLastd[1]);

            String d = firstLastd[2];
            
            Map <String,Integer> countMap= new HashMap<>();
            for(int j=first; j<=last;j++) {
                Integer count = countMap.get(genes[j]);
                if(count==null) {
                	int fromIndex =d.indexOf(genes[j],0)+1;
                	int counter=0;
                	while (fromIndex!=0) {
                		counter++;
                		healthScore[sItr]+=health[j];
                		fromIndex = d.indexOf(genes[j],fromIndex) + 1;
                	}
                	countMap.put(genes[j], counter);
                }
                else {
                	healthScore[sItr]+= count * health[j];
                }
                
            }
            if (healthScore[sItr] > max || sItr ==0) {
            	max = healthScore[sItr];
            }
            if(healthScore[sItr] < min || sItr == 0) {
            	min =healthScore[sItr]; 
            }
            
            
        }
        
        scanner.close();
        System.out.println(min+" "+ max);
        


        // Loop over the DNA strands
        // While on 1 DNA strand, find which genes to be checked
        // Find occurrences for each gene

      
      
     */

