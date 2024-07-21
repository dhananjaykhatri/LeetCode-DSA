class Solution {
    public int minChanges(int n, int k) {
        if ((n | k) != n) {
            return -1;
        }
        int changes = 0;
        while (n > 0) {
            if ((n & 1) == 1 && (k & 1) == 0) {
                changes++;
            }
            n >>= 1;
            k >>= 1;
        }
        return changes;
    }
}
// (2)
// public int minChanges(int n, int k) {
//     String binaryn = Integer.toBinaryString(n);
//     String binaryk = Integer.toBinaryString(k);

//     if (binaryk.length() > binaryn.length()) {
//         return -1;
//     }

//     int maxLength = Math.max(binaryn.length(), binaryk.length());
//     binaryn = String.format("%" + maxLength + "s", binaryn).replace(' ', '0');
//     binaryk = String.format("%" + maxLength + "s", binaryk).replace(' ', '0');

//     int changes = 0;
//     for (int i = 0; i < maxLength; i++) {
//         char bn = binaryn.charAt(i);
//         char bk = binaryk.charAt(i);

//         if (bk == '1' && bn == '0') {
//             return -1;
//         } else if (bn == '1' && bk == '0') {
//             changes++;
//         }
//     }

//     return changes;
// }