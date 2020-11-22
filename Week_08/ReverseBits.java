public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {            
            res ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
        }
        return res;
    }
}