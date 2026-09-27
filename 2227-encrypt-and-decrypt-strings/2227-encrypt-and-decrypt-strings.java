class Encrypter {
    HashMap<Character,String> map;
    Map<String, Integer> encryptedDictCount;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        map= new HashMap<>();
        encryptedDictCount = new HashMap<>();

        for(int i=0;i<keys.length;i++) map.put(keys[i],values[i]); 
       
        for (String word : dictionary) {
            String encrypted = encrypt(word);
            if (!encrypted.isEmpty()) {
                encryptedDictCount.put(encrypted, encryptedDictCount.getOrDefault(encrypted, 0) + 1);
            }
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word1.length();i++) {
            if(!map.containsKey(word1.charAt(i))) return "";
            sb.append(map.get(word1.charAt(i)));
        }
        return sb.toString();
    }
    
    public int decrypt(String word2) {
        return encryptedDictCount.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */