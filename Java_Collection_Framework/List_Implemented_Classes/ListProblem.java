// Source code is decompiled from a .class file using FernFlower decompiler.
package List_Implemented_Classes;

import java.util.ArrayList;
import java.util.Collections;

public class ListProblem {
   public ListProblem() {
   }

   public static void main(String[] var0) {
      ArrayList<Integer> var1 = new ArrayList<>();
      var1.add(2);
      var1.add(3);
      var1.add(5);
      var1.add(7);
      var1.add(9);
      var1.add(1);
      var1.add(0);
      System.out.println(var1);
      Collections.sort(var1, Collections.reverseOrder());
      System.out.println(var1);

   }
}
