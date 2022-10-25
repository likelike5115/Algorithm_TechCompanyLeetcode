import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author
 */
public class LetterCombinations_17 {
    //dfs solution
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<>();
        }
        Character[][] data = new Character[][]{{'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        List<String> res = new ArrayList<>();
        String ans = "";
        dfs(data,res, ans,digits);
        return res;
    }
    public void dfs(Character[][] data, List<String> res, String ans, String digits){
        if(ans.length() == digits.length()){
            res.add(ans);
            return;
        }
        int i = ans.length();
        int index = digits.charAt(i) - '2';
        //System.out.println(digits.charAt(i) + " " + index);
        for(int j = 0; j < data[index].length;j++){
            ans += data[index][j];
            dfs(data, res, ans, digits);
            ans = ans.substring(0, ans.length() - 1);
        }

    }
    //bfs
//    public List<String> letterCombinations2(String digits) {
//        if(digits.equals("")){
//            return new ArrayList<>();
//        }
//        Character[][] data = new Character[][]{{'a','b','c'},
//                {'d','e','f'},
//                {'g','h','i'},
//                {'j','k','l'},
//                {'m','n','o'},
//                {'p','q','r','s'},
//                {'t','u','v'},
//                {'w','x','y','z'}
//        };
//        List<String> res = new ArrayList<>();
//        String ans = "";
//        int index = digits.charAt(0) - '2';
//        for(int j = 0; j < data[index].length; j++){
//            res.add(data[index][j].toString());
//        }
//        return res;
//    }
}
