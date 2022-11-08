/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int returnArrayLength = 0;

    void clear() {
        for (int i = 0; storage[i] != null; i++) {
            storage[i] = null;
            returnArrayLength--;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                returnArrayLength++;
                break;
            }
        }
    }

    int searchUuid(String uuid) {
        int searchResult = -1;
        for (int i = 0; i < returnArrayLength; i++) {
            if (createReturnArray()[i].toString().equals(uuid)) {
                searchResult = i;
            }
        }
        return searchResult;
    }

    boolean checkSearchUuid(int searchResult) { 
        return searchResult >= 0;
    }

    Resume get(String uuid) {
        if (checkSearchUuid(searchUuid(uuid))) 
            return createReturnArray()[searchUuid(uuid)];
        else
            return null; //Как 
    }

    void delete(String uuid) {  
        if (checkSearchUuid(searchUuid(uuid))) {
            for (int i = searchUuid(uuid); storage[i] != null; i++) {
                storage[i] = storage[i + 1];
            }
            returnArrayLength--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] createReturnArray() {
        Resume[] returnArray = new Resume[returnArrayLength];
        for (int i = 0; i < returnArrayLength; i++) {  //IDEA предлагает System.arraycopy, я такое еще не умею
            returnArray[i] = storage[i];
        }
        return returnArray;
    }

    Resume[] getAll() {
        return createReturnArray();
    }

    int size() {
        return returnArrayLength;
    }
}
