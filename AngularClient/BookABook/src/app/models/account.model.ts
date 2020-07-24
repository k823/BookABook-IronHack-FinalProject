export interface Account {
    id: number;
    ownerId: number;
    ownerName: string;
    credit: number;
    isPremium: boolean;
    createdAt: Date;
}
