class ParkingSystem {
    int big, medium, small;
public:
    ParkingSystem(int big, int medium, int small) {
        this->big = big;
        this->medium = medium;
        this->small = small;
    }
    
    bool addCar(int carType) {
        if ((carType == 1 && big == 0) || (carType == 2 && medium == 0) || (carType == 3 && small == 0)) {
            return false;
        }
        
        if (carType == 1) {
            big--;
        } else if (carType == 2) {
            medium--;
        } else if (carType == 3) {
            small--;
        }
        
        return true;
    }
};
